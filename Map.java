import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map {
    public Double size_x, size_y, offset_x, offset_y, loc_x, loc_y;
    private BufferedImage background;


    public Map(Double xsize, Double ysize){
        size_x = xsize;
        size_y = ysize;
        offset_x = 0.0;
        offset_y = 0.0;
        try {
            background = ImageIO.read(new File("/Users/jasonzhang/Desktop/bg-1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint_background(Graphics2D g){
        g.drawImage(background, (int)Math.round(offset_x)-617, (int)Math.round(offset_y)-516, null);
        g.drawImage(background, (int)Math.round(offset_x)-607, (int)Math.round(offset_y)+221, null);
    }

    public void update(Double x_diff, Double y_diff){
        offset_x = (offset_x +597.0+ x_diff)%597.0;
        offset_y = (offset_y +516.0+ y_diff)%516.0;
    }
}
