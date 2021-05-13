package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Crop;
import model.Location;
import model.Mandi;
import model.Price;

public class DataSource {

    /**
     * Maharashtra, Nagpur, ABC, Tomato, Hybrid, 2021-03-07, 400
     * 
     * Maharashtra, Nagpur, ABC, Tomato, Country, 2021-03-07, 450
     * 
     * Maharashtra, Nagpur, ABC, Tomato, Hybrid, 2021-03-08, 450
     * 
     * Maharashtra, Nagpur, ABC, Tomato, Country, 2021-03-08, 500
     * 
     * Maharashtra, Nagpur, XYZ, Tomato, Hybrid, 2021-03-07, 450
     * 
     * Maharashtra, Nagpur, XYZ, Tomato, Country, 2021-03-07, 500
     * 
     */

    Location l;
    Mandi m1;
    Mandi m2;
    Crop c1;
    Crop c2;
    Price p1;
    Price p2;
    Price p3;
    Price p4;
    Price p5;
    Price p6;

    Map<Integer, List<Mandi>> mandiMap = new HashMap<>();
    Map<Integer, List<Price>> priceMap = new HashMap<>();

    List<Price> pl1 = new ArrayList<>();
    List<Price> pl2 = new ArrayList<>();
    List<Price> pl3 = new ArrayList<>();
    List<Price> pl4 = new ArrayList<>();

    List<Mandi> ml = new ArrayList<>();

    public void createSampleData() {

        l = new Location(1, "Maharashtra", "Nagpur");
        m1 = new Mandi(1, "ABC", l);
        m2 = new Mandi(2, "XYZ", l);
        c1 = new Crop(1, "Tomato", "Country");
        c2 = new Crop(2, "Tomato", "hybrid");

        p1 = new Price(new Date(2021, 3, 7), m1, c2, 400);
        p2 = new Price(new Date(2021, 3, 7), m1, c1, 450);
        p3 = new Price(new Date(2021, 3, 8), m1, c2, 450);
        p4 = new Price(new Date(2021, 3, 8), m1, c1, 500);
        p5 = new Price(new Date(2021, 3, 7), m2, c2, 450);
        p6 = new Price(new Date(2021, 3, 7), m2, c1, 500);

        pl1.add(p2);
        pl1.add(p4);
        pl2.add(p1);
        pl2.add(p3);
        pl3.add(p5);
        pl4.add(p6);

        priceMap.put(11, pl2);
        priceMap.put(12, pl1);
        priceMap.put(21, pl3);
        priceMap.put(22, pl4);

        ml.add(m1);
        ml.add(m2);

        mandiMap.put(l.getId(), ml);

    }

    public List<Price> getLatestPriceByDate(Location location, Crop crop) {

        // createSampleData();

        List<Price> prices = new ArrayList<>();

        // get list of location using specified location
        getMandisByLocation(location).forEach(m -> {
            // only get mandis using particular crop

            /** creating key for pricemap using composite ids */
            StringBuffer sb = new StringBuffer();
            sb.append(m.getId());
            sb.append(crop.getId());

            prices.addAll(priceMap.get(Integer.parseInt(sb.toString())));
        });

        // sort prices on date
        return prices.stream().sorted((p1, p2) -> p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());

    }

    public List<Price> getPriceTrend(Mandi mandi, Crop crop, int x, int y) {
        // createSampleData();

        StringBuffer sb = new StringBuffer();
        sb.append(mandi.getId());
        sb.append(crop.getId());
        // first we are filtering on limiting prices on certain number of days y
        // limiting the list size on x number of points
        return priceMap.get(Integer.parseInt(sb.toString())).stream().filter(p -> p.getDate().getDate() < y)
                .sorted((p1, p2) -> p1.getDate().compareTo(p2.getDate())).limit(x).collect(Collectors.toList());
    }

    private List<Mandi> getMandisByLocation(Location location) {
        return mandiMap.get(location.getId());
    }
}