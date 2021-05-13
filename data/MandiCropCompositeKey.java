package data;

public class MandiCropCompositeKey {
    private int m;
    private int c;

    public MandiCropCompositeKey(int m, int c) {
        this.m = m;
        this.c = c;
    }

    /**
     * @return int return the m
     */
    public int getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(int m) {
        this.m = m;
    }

    /**
     * @return int return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
    }

}
