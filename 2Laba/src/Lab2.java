import java.io.*;
import java.util.Scanner;
public class Lab2
{
    /**Reads an integer from console and runs a selected subprogramm*/
    public static void main(String[] args) throws IOException
    {
        System.out.println("What action do you want?:");
        System.out.println("1) Manually enter 3 points");
        System.out.println("2) Read 3 points from a file");
        Scanner scan = new Scanner(System.in);
        int choise = Integer.parseInt(scan.nextLine());
        switch (choise)
        {
            case 1:
            { Point3d point1 = inputPoint();
                Point3d point2 = inputPoint();
                Point3d point3 = inputPoint();
                double S = computeArea(point1,point2,point3);
                if (S==0.0)
                    System.out.println("Cannot compute area, two or more points are equal");
                else
                    System.out.println("Area is " + S); }
            case 2:
            { PointFileIO pfio = new PointFileIO();
                double S = computeArea(pfio.getValues());
                if (S==0.0)
                    System.out.println("Cannot compute area, two or more points are equal");
                else
                {
                    pfio.writeToFile(S);
                    System.out.println("File written successfully");
                } }
            default:
                System.out.println("Not a viable option");
        }


    }

    /**Reads a point as 3 coordinates on the axises*/
    public static Point3d inputPoint ()
    {
        Point3d point = new Point3d();
        Scanner scan = new Scanner(System.in);
        System.out.println("Create new point ");
        System.out.println("Enter x: ");
        double x = Double.parseDouble(scan.nextLine());
        point.setX(x);
        System.out.println("Enter y: ");
        double y = Double.parseDouble(scan.nextLine());
        point.setY(y);
        System.out.println("Enter z: ");
        double z = Double.parseDouble(scan.nextLine());
        point.setZ(z);
        return point;
    }

    /**Computes and area for 3 separate points*/
    public static double computeArea(Point3d point1, Point3d point2, Point3d point3)
    {
        if (point1.compareTo(point2) || point2.compareTo(point3) || point1.compareTo(point3))
            return 0.0;
        double a = point1.distanceTo(point2);
        double b = point2.distanceTo(point3);
        double c = point1.distanceTo(point3);
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    /**Computes an area for a massive of points*/
    public static double computeArea(Point3d[] pointMas)
    {
        if (pointMas[0].compareTo(pointMas[1]) || pointMas[1].compareTo(pointMas[2]) || pointMas[0].compareTo(pointMas[2]))
            return 0.0;
        double a = pointMas[0].distanceTo(pointMas[1]);
        double b = pointMas[0].distanceTo(pointMas[2]);
        double c = pointMas[1].distanceTo(pointMas[2]);
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
