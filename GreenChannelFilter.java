import java.awt.Color;
/**
 * Write a description of class RedChannelFilter here.
 *
 * @author James Patti
 * @version 11/24/25
 * 
 * green  channel filter - items that have a high blue  value for the pixel data appear lighter, with a maximum value of 255 appearing as white
 */
public class GreenChannelFilter extends Filter
{
    

    /**
     * Constructor for objects of class greenChannelFilter.
     * @param name The name of the filter.
     */
    public GreenChannelFilter(String name)
    {
        super(name);
    }
    
    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     * 
     * incorrect but setting up the start,
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                image.setPixel(x, y, image.getPixel(x, y));
                Color pixel  = image.getPixel(x,y);
                int green = pixel.getGreen(); //gets only the blue.
                
                Color newColor = new Color (green,green,green);
                image.setPixel(x,y,newColor);
                
            }
        }
    }

    
}