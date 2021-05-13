package model;

import java.util.Date;

public class Price {
    private Date date;
    private Mandi mandi;
    private Crop crop;
    private int value;

    public Price(Date date, Mandi mandi, Crop crop, int value) {
        this.date = date;
        this.mandi = mandi;
        this.crop = crop;
        this.value = value;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return Mandi return the mandi
     */
    public Mandi getMandi() {
        return mandi;
    }

    /**
     * @param mandi the mandi to set
     */
    public void setMandi(Mandi mandi) {
        this.mandi = mandi;
    }

    /**
     * @return Crop return the crop
     */
    public Crop getCrop() {
        return crop;
    }

    /**
     * @param crop the crop to set
     */
    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    /**
     * @return int return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return this.mandi.getName() + " " + this.crop.getName() + " " + this.crop.getVariety() + " " + this.getDate()
                + " " + this.value + "\n";
    }

}
