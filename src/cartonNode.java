/**
 * Created by Fincken on 14.10.2015.
 */
public class cartonNode {
    private boolean isEgg;
    private int x;
    private int y;
    private boolean isBad;
    private char cartonChar;

    public cartonNode(char isEgg, int x, int y){
        this.x = x;
        this.y = y;
        this.cartonChar = isEgg;
        switch (isEgg){
            case '.': this.isEgg = false;
                break;
            case '0': this.isEgg = true;
                break;
        }
    }

    public boolean isEgg() {
        return isEgg;
    }

    public void setEgg(boolean isEgg) {
        this.isEgg = isEgg;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isBad() {
        return isBad;
    }

    public void setBad(boolean isBad) {
        this.isBad = isBad;
        this.cartonChar = '1';
    }

    public String toString(){
        return this.cartonChar + "";
    }
}
