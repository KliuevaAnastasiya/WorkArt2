import java.io.*;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;
public class PointFileIO
{
    /**Reads points from a file*/
    public Point3d[] getValues()
    {
        String[] points = new String[3];
        Point3d[] pointMas = new Point3d[3];
        File file = new File("pointCollection.txt");

        try(Scanner scan = new Scanner(file))
        {
            while (scan.hasNext())
            {
                String s = scan.nextLine();
                points = s.split("-");
            }

            for (int i = 0; i<points.length; i++)
            {
                String[] tempMas = points[i].split(" ");
                pointMas[i] = new Point3d(tempMas);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return pointMas;

    }

    /**Writes to a file*/
    public void writeToFile(Double result)
    {
        try (FileWriter writer = new FileWriter("results.txt", false))
        {
            writer.write(Double.toString(result));
            writer.flush();
            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}