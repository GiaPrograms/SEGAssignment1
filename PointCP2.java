// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar or cartesian
 * format. It also provides the utilities to convert them into the other type.
 * It is not an optimal design, it is used only to illustrate some design
 * issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP2 {
  // Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of coordinates that are
   * being dealt with.
   */
  private char typeCoord;

  /**
   * Contains the current value of X or RHO depending on the type of coordinates.
   */
  private double xOrRho;

  /**
   * Contains the current value of Y or THETA value depending on the type of
   * coordinates.
   */
  private double yOrTheta;


  /* +++The purpose of this variable is that it can store a cartisian coordinatecomputed from the class
  PointCP3 base on the xOrRho and yOrTheta arguments. Meaning that convertion from polar to cartesian will not be store 
  by the xOrRho or yOrTheta variables and that the other class can handle the cartesion conversion calculation.+++    
   */
  private PointCP3 temporaryPoint;

  private PointCP3 newCartesianPoint;

  // Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP2(char type, double xOrRho, double yOrTheta) {
    if (type != 'C' && type != 'P'){
      throw new IllegalArgumentException();
    }
     
    this.xOrRho = xOrRho;
    this.yOrTheta = yOrTheta;
    typeCoord = type;

  }

  // Instance methods **************************************************

  public double getX() {

    //+++Have this method simply return the x value.+++
    return xOrRho;
  }

  public double getY() {

    //+++Have this method simply return the y value.+++
    return yOrTheta;
  }

  public double getRho() {
    if (typeCoord == 'P')
      return xOrRho;
    else
      return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
  }

  public double getTheta() {
    if (typeCoord == 'P')
      return yOrTheta;
    else
      return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
  }

  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar() {

    /*+++If the coordinate is not polar and that the cartesian coordinate does not equal the coordinate of this class
    then have the current class coordinates be equal to the cartesian coordinate created from PointCP3. Both X and Y 
    will be converted into polar coordinate and the type of PointCP2 will be mark as 'P'. The reason for the additional 
    requirement in the if statement is to ensure that the current coordinate will be chage into the new cartesian corrdinate 
    created by class PointCP3.+++
     */ 
  
      // Calculate RHO and THETA
      double temp = getRho();
      yOrTheta = getTheta();
      xOrRho = temp;

      typeCoord = 'P'; // Change coord type identifier
  }

  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public PointCP3 convertStorageToCartesian() {

    newCartesianPoint = new PointCP3(typeCoord, this.xOrRho, this.yOrTheta); 

    //+++Calculate X and Y coordinate from PointCP3+++
    newCartesianPoint.convertStorageToCartesian();

    xOrRho = newCartesianPoint.getX();
    yOrTheta = newCartesianPoint.getY();

    typeCoord = 'C'; // Change coord type identifier

    //+++Return a cartesian point+++
    return newCartesianPoint;
  }

  /**
   * Calculates the distance in between two points using the Pythagorean theorem
   * (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP2 pointB) {

    // +++Obtain differences in Rho and Theta, sign is not important as these values+++
    return Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(pointB.getRho(), 2) - (2 * xOrRho * pointB.getRho() * Math.cos(Math.toRadians(yOrTheta - pointB.getTheta()))));
  }

  /**
   * Rotates the specified point by the specified number of degrees. Not required
   * until E2.30
   *
   * @param point    The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP2 rotatePoint(double rotation) {
    double radRotation = Math.toRadians(rotation);
    double X = getRho();
    double Y = getTheta();

    return new PointCP2('P', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
        (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString() {
    //+++Cartesian coordinate is desplay instead of the cartesian coordinate of this class+++
    return "Stored as " + (typeCoord == 'C' ? "Cartesian  (" + convertStorageToCartesian().getX() + "," + convertStorageToCartesian().getY() + ")"
        : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
  }
}