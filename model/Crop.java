package model;

public class Crop {
    private int id;
    private String name;
    private String Variety;

    public Crop(int id, String name, String variety) {
        this.id = id;
        this.name = name;
        Variety = variety;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the Variety
     */
    public String getVariety() {
        return Variety;
    }

    /**
     * @param Variety the Variety to set
     */
    public void setVariety(String Variety) {
        this.Variety = Variety;
    }

}
