import java.awt.Color;
/**
 * Write a description of class WarholFilter here.
 *
 * @author James Patti)
 * @version 11/30/25
 * 
 * the peice la resistance, the warhole filter, using other 
 * filters ant making a image cross 4 ways.
 */
public class FlippedWarholFilter extends Filter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class WarholFilter
     */
    public FlippedWarholFilter(String name)
    {
       super(name);
    }
    

    

    /**
     * here lets see if we can make the application for a filter which 
     * divides image into 4 images , top left is normal, top right red tinted,
     * lower left green and finally blue/
     * 
     * ok first we need to make a set of methods to do this. 
     * this returns a green image.
     * 
     * 
     */
     @Override
    public void apply(OFImage image)
    {
        
        int width = image.getWidth();
        int height = image.getHeight();
        
         int halfWidth = width / 2;
        int halfHeight = height / 2;

        // here our copy so we know what imagre to sample from.
        OFImage original = new OFImage(image);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
        //get the samples.
        int screenX = x < halfWidth ? x * 2 : (x - halfWidth) * 2;
        int screenY = y < halfHeight ? y * 2 : (y - halfHeight) * 2;
        //flipper
        screenX = (width -1) - screenX;
        
        Color color = original.getPixel(screenX, screenY);
        
        Color newColor;
        
        //now the quadrants~ first normal
        if (x < halfWidth && y < halfHeight){
            newColor = color;
        }
        //red tint in top left
       else  if(x >= halfWidth && y < halfHeight){
            newColor =  tintRed(color);
        }
        else if(x < halfWidth && y >= halfHeight){
            newColor = tintGreen(color);
        }
        else {
            newColor = tintBlue(color);
        }
        
         image.setPixel(x, y, newColor);
        
    }
     
}
    
}  

// now the actual tint methods for above.

/**
 * a method to add the ability to tint photo red.
 * 
 * @parem is the color 
 * @return is a new color tinted how we want it.
 */

   private Color tintRed(Color c) {
        int r = Math.min(255, c.getRed() + 80);
        return new Color(r, c.getGreen(), c.getBlue());
    }
    /**
 * a method to add the ability to tint photo red.
 * 
 * @parem is the color 
 * @return is a new color tinted how we want it.
 */
    private Color tintGreen(Color c) {
     int g = Math.min(255, c.getGreen()+ 80);
    return new Color(c.getRed(), g, c.getBlue());
} 
/**
 * a method to add the ability to tint photo red.
 * 
 * @parem is the color 
 * @return is a new color tinted how we want it.
 */
  private Color tintBlue(Color c) {
        int b = Math.min(255, c.getBlue() + 80);
        return new Color(c.getRed(), c.getGreen(), b);
    }
}