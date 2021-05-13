import model.Crop;
import model.Location;
import model.Mandi;
import service.MandiLookupService;

public class MandiLookupApplication {

    // injecting service in application runtime, our service here is working as
    // controller
    // ideally we should not create a new object of this service and rather create a
    // singleton object as we can just use this object to retrieve all the results
    static MandiLookupService service = new MandiLookupService();

    public static void main(String[] args) {
        System.out.println("Mandi Lookup Application");

        // we will get these hardcoded values from an exposed controller from
        // @RequestMapping
        Location l = new Location(1, "Maharashtra", "Nagpur");
        Crop c = new Crop(1, "Tomato", "Country");
        Mandi m = new Mandi(1, "ABC", l);

        System.out.println(service.getLatestPriceByDate(l, c));

        System.out.println(service.getPriceTrend(m, c, 5, 9));

    }

}