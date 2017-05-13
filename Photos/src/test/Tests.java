
package test;

import implementation.Photo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 *
 * @author samuel
 */

public class Tests {
    
    @Test
    public void testing() {
        Photo photo = new Photo();
        assertEquals(true, photo.resize("http://54.152.221.29/images.json"), "Error!");
    }
}
