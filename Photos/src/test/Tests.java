
package test;

import implementation.Photo;


/**
 *
 * @author samuel
 */

public class Tests {
    
    public void testing() {
        if(!new Photo().resize("http://54.152.221.29/images.json"))
            System.out.println("Error during execution");
        else
            System.out.println("Test run successfully");
    }
}
