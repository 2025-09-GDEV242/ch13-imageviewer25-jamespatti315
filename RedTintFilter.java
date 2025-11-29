import java.awt.Color;
/**
 * Write a description of class RedChannelFilter here.
 *
 * @author James Patti
 * @version 11/24/25
 * 
 * red tint  filter - gives everything a red tint naturall.
 */
public class RedTintFilter extends Filter
{
    

    /**
     * Constructor for objects of class RedChannelFilter.
     * @param name The name of the filter.
     */
    public RedTintFilter(String name)
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
                Color color = image.getPixel(x, y);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            
            int redTint  = Math.min(255, r + 80);  // a decent red tint, suck at the maths.
                
               Color newColor = new Color(redTint,g,b);
            image.setPixel(x, y, newColor);
                
            }
        }
    }

    
}