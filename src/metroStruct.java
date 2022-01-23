import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class metroStruct {
    @SerializedName("lines")
    private List<LineStruct>  lineSt;
    @SerializedName("station")
    private  Map<String,List<String>> stationSt ;

    public metroStruct(List<LineStruct> lineSt,Map<String, List<String>> stationSt)
    {
        this.lineSt = lineSt;
        this.stationSt = stationSt;
    }

    public List<LineStruct> getLine()
    {
        return lineSt;
    }
}
