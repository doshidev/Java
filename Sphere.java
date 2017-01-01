/**
 * PP4.1 Java Software Solutions
 * Created by Devang on 31-Dec-16.
 */

import java.text.DecimalFormat;

public class Sphere
{
    double diameter;
    double radius;

    public Sphere(double d){
        diameter = d;
        radius = diameter/2;
    }

    public double volume(){
        double vol = (4.0/3) * Math.PI * Math.pow(radius, 3);
        return vol;
    }

    public double area(){
        double area = 4.0 * Math.PI * Math.pow(radius, 2);
        return area;
    }

    public double getDiameter(){
        return this.diameter;
    }

    public void setDiameter(double d){
        this.diameter = d;
    }

    public String toString(){
        String sphere;
        sphere = "Sphere [d: " + diameter + ", r: " + radius + "]";
        return sphere;
    }

    public static void main(String[] args){
        testSphere(new Sphere(5.0));
        testSphere(new Sphere(6.3));
        testSphere(new Sphere(12.5));
        testSphere(new Sphere(0.8));

    }

    public static void testSphere(Sphere s){
        DecimalFormat fmt = new DecimalFormat("0.###");

        System.out.println();
        System.out.println(s);
        System.out.println("D: " + s.getDiameter());
        System.out.println("Volume: " + fmt.format(s.volume()));
        System.out.println("Area: " + fmt.format(s.area()));
        s.setDiameter(1.0);
        System.out.println("New D set to: " + s.getDiameter());
        System.out.println("\n------------------------");
    }
}
