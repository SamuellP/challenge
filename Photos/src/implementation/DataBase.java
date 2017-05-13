package implementation;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import java.awt.image.BufferedImage;
import java.net.URL;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author samuel
 */
public class DataBase implements Runnable{
    
    private MongoClient mongo;
    public URL photo;
    public String dimension;
    
    public DataBase(MongoClient mongo, URL photo, String dimension){
        this.photo = photo;
        this.dimension = dimension; 
        this.mongo = mongo;
    }
    
    @Override
    public void run() {
        BufferedImage bufferedImage;
        
        DB db;
        DBCollection dbCollection;
        BasicDBObject document;
        GridFS gridFS;
        GridFSInputFile gridFSInputFile;
        
        try{
            if(this.dimension.equals("small"))
                bufferedImage = Thumbnails.of(this.photo).size(320, 240).outputFormat("jpg").asBufferedImage();
            else if(this.dimension.equals("medium"))
                bufferedImage = Thumbnails.of(this.photo).size(384, 288).outputFormat("jpg").asBufferedImage();
            else
                bufferedImage = Thumbnails.of(this.photo).size(640, 480).outputFormat("jpg").asBufferedImage();
            
            db = mongo.getDB("challenge");
            dbCollection = db.getCollection("photos");
            
            gridFS = new GridFS(db, "photo");
            gridFSInputFile = gridFS.createFile(this.photo.openStream());
            gridFSInputFile.setFilename(this.dimension);

            document = new BasicDBObject();
            document.put(this.dimension, gridFSInputFile);
            
            dbCollection.insert(document);
            
        }catch(Exception e){
            System.out.println("Erro durante a execução!");
        }
                
    }
    
}
