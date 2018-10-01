// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP3 implements PointCP6<PointCP2, PointCP3>
{
   //Instance variables ************************************************

   /**
    * Contains C(artesian) or P(olar) to identify the type of
    * coordinates that are being dealt with.
    */
   private char typeCoord;
   
   /**
    * Contains the current value of X or RHO depending on the type
    * of coordinates.
    */
   private double xOrRho;
   
   /**
    * Contains the current value of Y or THETA value depending on the
    * type of coordinates.
    */
   private double yOrTheta;
	
   /* +++The purpose of this variable is that it can store a polar coordinatecomputed from the class
   PointCP2 base on the xOrRho and yOrTheta arguments. Meaning that convertion from cartesian to polar will not be store 
   by the xOrRho or yOrTheta variables and that the other class can handle the cartesion conversion calculation.+++    
    */

   private PointCP2 newPolarPoint;
   
   //Constructors ******************************************************

   /**
    * Constructs a coordinate object, with a type identifier.
    */
   public PointCP3(char type, double xOrRho, double yOrTheta)
   {
      if(type != 'C' && type != 'P')
         throw new IllegalArgumentException();
      this.xOrRho = xOrRho;
      this.yOrTheta = yOrTheta;
      typeCoord = type;
   }
	
    
   //Instance methods **************************************************
  
  
   public double getX()
   {
      if(typeCoord == 'C') 
         return xOrRho;
      else 
         return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
   }
   
   public double getY()
   {
      if(typeCoord == 'C') 
         return yOrTheta;
      else 
         return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
   }
   
   public double getRho()
   {
      return xOrRho;
     
   }
   
   public double getTheta()
   {
   
      return yOrTheta;
   }
   
	
   /**
    * Converts Cartesian coordinates to Polar coordinates.
    */
   public PointCP2 convertStorageToPolar()
   {  

      newPolarPoint = new PointCP2 (typeCoord, xOrRho , yOrTheta);

      newPolarPoint.convertStorageToPolar();//calls cp2 to make a new object

      xOrRho = newPolarPoint.getRho();
      yOrTheta = newPolarPoint.getTheta();
      
      typeCoord= 'P';//changed, so its polar now
      
      return newPolarPoint;  //return the object created
   }
	
   /**
    * Converts Polar coordinates to Cartesian coordinates.
    */
   public PointCP3 convertStorageToCartesian()
   {
      PointCP3 newPolarPoint = new PointCP3 (typeCoord, xOrRho , yOrTheta);

      if(typeCoord != 'C')
      {
         //Calculate X and Y
         double temp = getX();
         yOrTheta = getY();
         xOrRho = temp;
      
         typeCoord = 'C';	//Change coord type identifier
      }

      return newPolarPoint;
   }

   /**
    * Calculates the distance in between two points using the Pythagorean
    * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
    *
    * @param pointA The first point.
    * @param pointB The second point.
    * @return The distance between the two points.
    */
   public double getDistance(PointCP pointB)
   {
      // Obtain differences in X and Y, sign is not important as these values
      // will be squared later.
      double deltaX = getX() - pointB.getX();
      double deltaY = getY() - pointB.getY();
      
      return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
   }

   /**
    * Rotates the specified point by the specified number of degrees.
    * Not required until E2.30
    *
    * @param point The point to rotate
    * @param rotation The number of degrees to rotate the point.
    * @return The rotated image of the original point.
    */

   public PointCP rotatePoint(double rotation)
   {
      double radRotation = Math.toRadians(rotation);
      double X = getX();
      double Y = getY();
          
      return new PointCP('C',
         (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
         (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
   }

   /**
    * Returns information about the coordinates.
    *
    * @return A String containing information about the coordinates.
    */
   public String toString()
   {
      return "Stored as " + (typeCoord == 'C' 
          ? "Cartesian  (" + getX() + "," + getY() + ")"
          : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
   }
}