package service;

import java.util.List;

import data.DataSource;
import model.Crop;
import model.Location;
import model.Mandi;
import model.Price;

public class MandiLookupService {

    // ideally we should not create a new object of this service and rather create a
    // singleton object as we can just use this object to retrieve all the results
    DataSource dataSource = new DataSource();

    public List<Price> getLatestPriceByDate(Location l, Crop c) {

        dataSource.createSampleData();

        return dataSource.getLatestPriceByDate(l, c);
    }

    // for simplicity y is exact day number
    public List<Price> getPriceTrend(Mandi m, Crop c, int x, int y) {

        dataSource.createSampleData();

        return dataSource.getPriceTrend(m, c, x, y);
    }
}
