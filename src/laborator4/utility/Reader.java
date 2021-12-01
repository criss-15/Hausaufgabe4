package laborator4.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {

    public static List<List<String>> readFile(String file){
        List<List<String>> toReturn = new ArrayList<>();

        String line;
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(file));
            while( (line = bufferedReader.readLine()) != null){
                
                String[] data = line.split(",");
                toReturn.add(Arrays.asList(data));


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(bufferedReader != null){
                try{
                    bufferedReader.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return toReturn;
    }

}
