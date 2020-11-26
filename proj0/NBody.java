import java.lang.reflect.Array;
import java.util.ArrayList;

public class NBody {
    public static double readRadius(String path) {
        if (path.length() == 0) {
            System.out.println("Please supply a country as a command line argument.");
            System.out.println("For countries with spaces, use an underscore, e.g. South_Korea");
        }
        In in = new In(path);
        double d;

        while (!in.isEmpty()) {
            try {
                in.readInt();
            } catch (Exception e) {
                try {
                    d = in.readDouble();
                    return d;
                } catch (Exception e1) {
                    System.out.println("Please enter double. ");
                }
                System.out.println("Please enter double. ");
            }
        }
        return 0;
    }

    public static Planet[] readBodies(String path) {
        if (path.length() == 0) {
            System.out.println("Please supply a country as a command line argument.");
            System.out.println("For countries with spaces, use an underscore, e.g. South_Korea");
        }
        In in = new In(path);
        double d;
        int i = 0;

        while (!in.isEmpty()) {
            try {
                i = in.readInt();
            } catch (Exception e) {
                try {
                    d = in.readDouble();
                    break;
                } catch (Exception e1) {
                    System.out.println("Please enter double. ");
                }
                System.out.println("Please enter double. ");
            }
        }

        Planet[] bodies = new Planet[i];
//        ArrayList<Planet> bodyArrayList = new ArrayList<Planet>();
        double xxPos;
        double yyPos;
        double xxVel;
        double yyVel;
        double mass;
        String imgFileName;
        for (int j = 0; j < i; j++) {
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            imgFileName = in.readString();
            bodies[j] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
//            bodyArrayList.add(new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName));
        }
        return bodies;

    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] bodies = readBodies(filename);

        int count_bodies = bodies.length;

//        double t=0;
        double[] xForces = new double[count_bodies];
        double[] yForces = new double[count_bodies];

        StdDraw.enableDoubleBuffering();

        for (int t = 0; t < T; t++) {
            StdDraw.setScale(-radius, radius);
            StdDraw.clear();


//            calculate the xForeces and yForeces arryas
            int ii = 0;
            for (Planet p : bodies) {
                xForces[ii] = p.calcNetForceExertedByX(bodies);
                yForces[ii] = p.calcNetForceExertedByY(bodies);
                ii++;
            }

            ii = 0;
            for (Planet p : bodies) {
                p.update(dt, xForces[ii], yForces[ii]);
                ii++;
            }


            StdDraw.picture(0, 0, "images/starfield.jpg");

//            draw bodies
            for (Planet p : bodies) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }


    }
}