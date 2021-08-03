import javax.swing.*;
import java.awt.*;
import java.awt.Color ;
import java.awt.image.BufferedImage;

public class Mandelbrot extends JPanel{

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

    BufferedImage image;

    // constructor for zero input arguments
    public Mandelbrot(){
        this.realMin = -1;
        this.realMax = 1;
        this.complexMin = -1;
        this.complexMax = 1;
        this.iteration = 1000;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    // consructor for four unput arguments
    public Mandelbrot(double realMin, double realMax, double complexMin, double complexMax){
        this.iteration = 1000;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.realMin = realMin;
        this.realMax = realMax;
        this.complexMin = complexMin;
        this.complexMax = complexMax;
    }

    // constructor for five input arguments
    public Mandelbrot(double realMin, double realMax, double complexMin, double complexMax, int iteration){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.realMin = realMin;
        this.realMax = realMax;
        this.complexMin = complexMin;
        this.complexMax = complexMax;
        this.iteration = iteration;
    }

    // map the points on the canvas to the complex plain 
    public void setPoint(){
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                real= (double)x*(realMax - realMin)/WIDTH + realMin;
                imaginary= (double)y*(complexMax - complexMin)/HEIGHT + complexMin;
                setColour(x,y,checkPoint(real, imaginary));
            }
        }
        setFrame("Mandelbrot Set");
    }

    //if absolute value of complex number is larger than 2 return 0 
    public int checkPoint(double realC,double imaginaryC){
        double realZ = 0;
        double complexZ = 0;
        int n = 0;

        while(n++ <= iteration){
            double temp = realZ;
            realZ = Math.pow(realZ,2) - Math.pow(complexZ,2) + realC;
            complexZ = 2*temp*complexZ + imaginaryC;
	    if((realZ*realZ + complexZ*complexZ) > 4) return 0 ;
        }
        return 1 ;
    }



    //Set the frame
    public void setFrame(String frameName){
       JFrame frame = new JFrame(frameName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.add(this);
        frame.setVisible(true);
    }

    // assign colors for points
    public void setColour(int x, int y, int count){
        if(count == 1){
            image.setRGB(x, y, black);
        }
        if(count == 0){
            image.setRGB(x, y, white);
        }

    }

    // draw the image
    @Override
    public void paint(Graphics g){
        g.drawImage(image,0,0,null);
    }
}
