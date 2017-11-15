import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Snake {
    public ArrayList<Double> cord;
    public Double head_x, head_y, current_x, current_y, diameter, stepsize, lastangle, limit, locx, locy;
    private Color paint1, paint2;
    private Boolean gradient, boosting;

    public Snake(Double x, Double y, Color p1, Color p2){
        cord = new ArrayList<Double>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,
                0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,
                0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0
                ,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        head_x = 400.0;
        head_y = 240.0;
        paint1 = p1;
        paint2 = Color.GREEN;
        diameter = 30.0;
        stepsize = 6.0;
        locx = locy = 0.0;
        lastangle = 0.0;
        limit = 0.29;
        gradient = false;
        boosting = false;
    }

    public void draw_snake(Graphics2D g2d){
        g2d.setPaint(paint1);
        g2d.fill(new Ellipse2D.Double(head_x, head_y, diameter, diameter));
        if (gradient)
            g2d.setPaint(new GradientPaint(5, 30, paint1, 35, 100, paint2, true));
            //set gradient
        if (boosting){
            g2d.setPaint(new GradientPaint(5, 30, paint1, 35, 100, Color.YELLOW, true));
        }
        current_x = head_x;
        current_y = head_y;
        for(int i = cord.size()-1; i > 0; i --){
            current_y += stepsize * Math.cos(cord.get(i));
            current_x += stepsize * Math.sin(cord.get(i));
            g2d.fill(new Ellipse2D.Double(current_x, current_y, diameter, diameter));
        }
        //g2d.fill(new Ellipse2D.Double(head_x, head_y, diameter, diameter));
    }

    public void update(Double angle, Map map, JLabel mouseloc){
        cord.remove(0);
        if ((Math.abs(angle - lastangle) < limit) || (6.283 - Math.abs(angle - lastangle) < limit))
            lastangle = angle;
        else if (Math.abs(angle - lastangle) > 3.1415)
            lastangle += -limit * Math.signum(angle-lastangle);
        else
            lastangle += limit * Math.signum(angle-lastangle);
        cord.add(lastangle);
        locx -= stepsize * Math.sin(lastangle);
        locy -= stepsize * Math.cos(lastangle);
        mouseloc.setText("(" + locx + "," + locy + ")");;
        map.update(stepsize * Math.sin(lastangle), stepsize * Math.cos(lastangle));
    }

    public void set_color(Color c1, Color c2){
        paint1 = c1;
        paint2 = c2;
    }

    public void set_gradient(){
        gradient = !gradient;
    }

    public void set_head_loc(Double x, Double y){
        head_x = x - diameter/2;
        head_y = y - diameter/2;
    }

    public void set_boosting(Boolean bool){
        boosting = bool;
        if (boosting)
            limit = 0.19;
        else
            limit = 0.29;
    }
}
