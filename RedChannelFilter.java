
/**
 * Write a description of class RedChannelFilter here.
 *
 * @author James Patti
 * @version 11/24/25
 * 
 * red channel filter - items that have a high red value for the pixel data appear lighter, with a maximum value of 255 appearing as white
 */
public class RedChannelFilter extends Filter
{
    

    /**
     * Constructor for objects of class RedChannelFilter.
     * @param name The name of the filter.
     */
    public RedChannelFilter()
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
                image.setPixel(x, y, image.getPixel(x, y).brighter());
            }
        }
    }

    
}