package implementation;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author samuel
 */
public class Photo {
    
    public void resize(String urlJson){
        
        Thread[] threads;
        
        String jsonString;
        JSONObject json;
        JSONObject jsonObject;
        JSONArray jsonArray;
        
        MongoClient mongo = new MongoClient("localhost",27017);
        
        try{
            
            threads = new Thread[100];
            
            
            //db = mongo.getDB("challenge");
            
            
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
                
                //while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive()) { }
                //bufferedImage = Thumbnails.of(new URL((String)jsonObject.get("url"))).size(320, 240).outputFormat("jpg").asBufferedImage();
                //document.put("small","oi");
                //ImageIO.write(bufferedImage, "png", new File("/tmp/small.png"));
                //bufferedImage = Thumbnails.of(new URL((String)jsonObject.get("url"))).size(384, 288).outputFormat("jpg").asBufferedImage();
                //document.put("medium","oi");
                //ImageIO.write(bufferedImage, "png", new File("/tmp/medium.png"));
                //bufferedImage = Thumbnails.of(new URL((String)jsonObject.get("url"))).size(640, 480).outputFormat("jpg").asBufferedImage();
                //document.put("large","oi");
                //ImageIO.write(bufferedImage, "png", new File("/tmp/large.png"));
                
                //dbCollection.insert(document);
                j += 3;
            }
            
            
        }catch(Exception e){
            System.out.println("Erro durante a execução!");
        }
        
    }
    
}
