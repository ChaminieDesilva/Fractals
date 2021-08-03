import javax.swing.*;
import java.awt.*;
import java.awt.Color ;
import java.awt.image.BufferedImage;

public class Julia extends JPanel{

    // create variables

    public int HEIGHT = 800;
    public int WIDTH = 800;

    public double realMin;
    public double realMax;
    public double complexMin;
    public double complexMax;
    public int iteration;

    public double real;
    public double imaginary;

    public int black = new Color(0,0,0).getRGB();
    public int white = new Color(255,255,255).getRGB();

    public BufferedImage image;

    // constructor for zero arguments
    public Julia(){
        this.realMin = -1;
        this.realMax = 1;
        this.complexMin = -1;
        this.complexMax = 1;
        this.iteration = 1000;
        this.real = -0.4;
        this.imaginary = 0.6;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    // constructor for two arguments
    public Julia(double real, double imaginary){
        this.realMin = -1;
        this.realMax = 1;
        this.complexMin = -1;
        this.complexMax = 1;
        this.iteration = 1000;
        this.real = real;
        this.imaginary = imaginary;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    // constructor for three arguments
    public Julia(double real, double imaginary, int iteration){
        this.realMin = -1;
        this.realMax = 1;
        this.complexMin = -1;
        this.complexMax = 1;
        this.iteration = iteration;
        this.real = real;
        this.imaginary = imaginary;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }


    // map the points on the canves to complex plain
    public void setPoint(){
        double realZ;
        double imaginaryZ;

        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                realZ = (double)x*(realMax - realMin)/WIDTH + realMin;
                imaginaryZ = -(double)y*(complexMax - complexMin)/HEIGHT + complexMax;
                setColour(x,y,checkPoint(realZ, imaginaryZ));
            }
        }
        setFrame("Julia set");
    }

    //if absolute value of complex number is larger than 2 return 0 
    public int checkPoint(double realZ,double imaginaryZ){
        int n = 0;

        while(n++ <= iteration){
            double temp = realZ;
            realZ = realZ*realZ - imaginaryZ*imaginaryZ + this.real;
            imaginaryZ = 2*temp*imaginaryZ + this.imaginary;
	    if((realZ*realZ + imaginaryZ*imaginaryZ) > 4) return 0 ;
        }
        return 1;
    }

    //Set frame for draw the relavent set
    public void setFrame(String s){
       JFrame frame = new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.add(this);
        frame.setVisible(true);
    }

    // set the colour for the given point
    public void setColour(int x, int y, int count){
        if(count == 1){
        	// if the point is in the set, color is black 
            image.setRGB(x, y, black);
        }
        if(count == 0){
        	// if the point is not in the set, color is white
            image.setRGB(x, y, white);
        }

    }

    // draw the image
    @Override
    public void paint(Graphics g){
        g.drawImage(image,0,0,null);
    }
}
