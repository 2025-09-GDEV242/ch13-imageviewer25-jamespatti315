import java.awt.Color;
/**
 * Write a description of class greenChannelFilter here.
 *
 * @author James Patti
 * @version 11/24/25
 * 
 * green  tint  filter - gives everything a blue  tint naturall.
 */
public class GreenTintFilter extends Filter
{
    

    /**
     * Constructor for objects of class greenChannelFilter.
     * @param name The name of the filter.
     */
    public GreenTintFilter(String name)
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
            
            int greenTint  = Math.min(255, g + 80);  // a decent red tint, suck at the maths.
                
               Color newColor = new Color(r,greenTint,b);
            image.setPixel(x, y, newColor);
                
            }
        }
    }

    
}