// Fractal class which contain main method
public class Fractal {

    public static void main(String[] args) {
	// get the number of arguments has given 
        int length = args.length;

	if(length == 0) {
		
System.out.println("The set is not given.") ;
		return ;
	}
	// mandelbrot set
        if(args[0].equalsIgnoreCase("Mandelbrot")){
		
		// zero arguments
            if(length == 1){
                Mandelbrot  m = new Mandelbrot();
                m.setPoint();
		// 4 arguments
            }else if(length == 5){
            	double x_min = Double.parseDouble(args[1]);
            	double x_max = Double.parseDouble(args[2]);
            	double y_min = Double.parseDouble(args[3]);
            	double y_max = Double.parseDouble(args[4]);
			// check the given boundary values 
	            if((x_min<-1 || y_min<-1) || (x_max>1 || y_max>1)){
			// wrong boundary values
	            	printError() ;
	            }
                Mandelbrot m = new Mandelbrot(x_min,x_max,y_min,y_max);
                m.setPoint();
		// five arguments 
            }else if(length == 6){
            	double x_min = Double.parseDouble(args[1]);
            	double x_max = Double.parseDouble(args[2]);
            	double y_min = Double.parseDouble(args[3]);
            	double y_max = Double.parseDouble(args[4]);
			// check the given boundary values 
	            if((x_min<-1 || y_min<-1) || (x_max>1 || y_max>1)){
			// wrong boundary values
	            	printError() ;
	            }
                Mandelbrot m = new Mandelbrot(x_min,x_max,y_min,y_max,Integer.parseInt(args[5]));
                m.setPoint();
            }
	    else{
		// print usage messege
		printUsageM();
	    }

        }
	// julia set
        else if(args[0].equalsIgnoreCase("Julia")){
		// zero arguments
            if(length == 1){
                Julia j = new Julia();
                j.setPoint();
		// two arguments
            }else if(length == 3){
                Julia j = new Julia(Double.parseDouble(args[1]),Double.parseDouble(args[2]));
                j.setPoint();
		// three arguments
            }else if(length == 4){
                Julia j = new Julia(Double.parseDouble(args[1]),Double.parseDouble(args[2]), Integer.parseInt(args[3]));
                j.setPoint();
            }else{
		// print usage messege 
		printUsageJ();
            }
        } 
	else{
		System.out.println("Wrong input") ;
	}

    }
	// usage for mandelbrot set
    public static void printUsageM(){
	System.out.println("Usage:");
    	System.out.println("java Fractal Mandelbrot");
    	System.out.println("java Fractal Mandelbrot x_min x_max y_min y_max ");
    	System.out.println("java Fractal Mandelbrot x_min x_max y_min y_max iterations");
    	System.exit(0);
    }

	// usage for julia set
    public static void printUsageJ(){
	System.out.println("Usage:");
    	System.out.println("java Fractal Julia");
    	System.out.println("java Fractal Julia x y ");
    	System.out.println("java Fractal Julia x y iterations");
    	System.exit(0);
    }


	//error printing method
    public static void printError(){
    	System.out.println("Error : (-1 <= valid_complex_range <= 1) , (-1 <= valid_real_range <= 1") ;
    	System.exit(0) ;
    }
}
