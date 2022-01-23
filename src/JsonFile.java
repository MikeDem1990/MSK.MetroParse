import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;



public class JsonFile {

    private static metroStruct metStr;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

     static void createJson(List<LineStruct> lineSt, Map<String, List<String>> stationSt) throws IOException {

         metStr = new metroStruct(lineSt, stationSt);

         try (FileWriter file_written = new FileWriter("Resource\\metroFile.json")) {


             file_written.write(gson.toJson(metStr));

             file_written.flush();
             file_written.close();
         } catch (IOException exception)
         {
             exception.printStackTrace();
         }





    }





}
