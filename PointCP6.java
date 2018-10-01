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
public interface PointCP6<T, S>
{
 
  double getX();
  
  double getY();

  double getRho();
  
  double getTheta();
	
  T convertStorageToPolar();
	
  S convertStorageToCartesian();

  double getDistance(PointCP pointB);
 
  PointCP rotatePoint(double rotation);
  
  String toString();
  
}