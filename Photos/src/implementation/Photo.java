package implementation;

import com.mongodb.MongoClient;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author samuel
 */
public class Photo {
    
    public boolean resize(String urlJson){
        
        Thread[] threads;
        
        String jsonString;
        JSONObject json;
        JSONObject jsonObject;
        JSONArray jsonArray;
        
        MongoClient mongo;
        
        try{
            
            threads = new Thread[100];
            
            
            mongo = new MongoClient("localhost",27017);
            
            
            jsonString = IOUtils.toString(new URL(urlJson).openStream());
            json = (JSONObject) JSONValue.parseWithException(jsonString);
            jsonArray = (JSONArray) json.get("images");
            
            int j = 0;
            for(int i = 0; i < jsonArray.size(); i++){
                
                jsonObject = (JSONObject) jsonArray.get(i);
                
                
                threads[j] = new Thread(new DataBase(mongo,new URL((String)jsonObject.get("url")),"small"));
                threads[j+1] = new Thread(new DataBase(mongo,new URL((String)jsonObject.get("url")),"medium"));
                threads[j+2] = new Thread(new DataBase(mongo,new URL((String)jsonObject.get("url")),"large"));
                
                threads[j].start();
                threads[j+1].start();
                threads[j+2].start();
                
                j += 3;
            }
            
            return true;
            
        }catch(Exception e){
            System.out.println("Erro durante a execução!");
            return false;
        }
        
    }
    
}
