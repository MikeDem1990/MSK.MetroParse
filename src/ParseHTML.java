import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParseHTML {

    private static Map<String,List<String>> stationList = new TreeMap<>();
    private static List<LineStruct> linelist = new ArrayList<>();



    public static void Parse_html(Document arg) throws IOException {


//        Element table = arg.select("table.standart").get(2);
//        Elements rows = table.select("td");
//        Elements title = rows.select("a");
//        //rows.forEach(element -> {System.out.println(element.text());});
//        for (int i =0 ; i<rows.size(); i++)
//        {
//            System.out.println(title.get(i).text());
//        }


//        Elements elem = arg.select(".standard.sortable");
//        Elements rews = elem.select("tr");
//        for (int i = 1 ; i<rews.size();i++)
//        {
//            Element r = rews.get(i);
//            Elements row = r.select("td");
//            System.out.println(row.get(1).text());
//            System.out.println(row.get(2).text());
//            System.out.println(row.get(3).text());
//        }

        Elements rows = arg.select("table").get(2).select("tr");
        rows.stream().skip(1).forEach(row -> {
            Elements cell = row.select("td");
            String station = cell.get(1).text();
            String line = cell.get(0).child(1).attr("title");
            List<String> lineNumbers = cell.get(0).children().eachText();
            List<String> connectionsLineName = cell.get(0).children().eachAttr("title");
            List<String> transfersNumber = cell.get(3).children().eachText();

            stationParse(station,lineNumbers,connectionsLineName);
            linesParse(line,lineNumbers);


            try {
                JsonFile.createJson(linelist,stationList);
            } catch (IOException e) {
                e.printStackTrace();
            }


//            System.out.println(connectionsLineName);
//            System.out.println(transfersNumber);
        });

//        for (int i = 0 ; i < rows.size() ; i++) {
//
//            String station = rows.select("").text();
//            System.out.println(station);
//
//        }

//        arg.select("table.standard.sortable").select("tr").stream()
//                .map(element -> element.select("td"))
//                .filter(elements -> elements.size() != 0)
//                .forEach(ParseHTML::createStationFromJsoup);



//
//        elem.forEach((element)-> {
//
//
//                    String lineName = elem.get(0).child(1).attr("title");
//                    String StationName = elem.get(1).text();
//                    System.out.println(lineName);
//                    System.out.println(StationName);
//                }
//        );
//        for (int i =0 ; i<elem.size(); i++)
//        {
//            //System.out.println(elem.get(i).text());
//            System.out.println(lineName);
//        }



    }

    static void stationParse(String station , List<String> lineNumbers , List<String> transfersNumber )
    {

        String checkLineId = lineNumbers.get(0);
        if (!stationList.containsKey(checkLineId))
        {
            stationList.put(checkLineId, new ArrayList<>());
            stationList.get(checkLineId).add(station);
        } else stationList.get(checkLineId).add(station);




    }

    static void linesParse (String line , List<String> lineNumbers)
    {
        LineStruct lineStruct = new LineStruct(lineNumbers.get(0),line);

        if (!linelist.contains(lineStruct))
        {
            linelist.add(lineStruct);

        }
    }

//    public static void createStationFromJsoup(Elements elements) {
//
//        System.out.println(elements.get(1).text());
//        //System.out.println(elements.get(2).text());
//
//
//    }
}
