/**
 * Created by GetFire on 23.01.2017.
 */
public class DataModel {
    private String one;
    private  String  two;
    private String three;
    private String four;

    public DataModel(String one, String two, String three, String four) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    public DataModel(String one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four ="";
    }

    @Override
    public String toString() {

        return "DataModel{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                ", three='" + three + '\'' +
                ", four='" + four + '\'' +
                '}';
    }

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public String getThree() {
        return three;
    }

    public String getFour() {
        return four;
    }
}
