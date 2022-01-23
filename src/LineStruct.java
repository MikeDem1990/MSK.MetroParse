import java.util.Objects;

public class LineStruct {


    private String number;
    private String name;


    public LineStruct(String number , String name)
    {
        this.number = number;
        this.name = name;


    }


    public String getName() {
        return name;
    }



    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineStruct line = (LineStruct) o;
        return Objects.equals(number, line.number) &&
                Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }



}
