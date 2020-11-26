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

    public static Body[] readBodies(String path) {
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

        Body[] bodies = new Body[i];
//        ArrayList<Body> bodyArrayList = new ArrayList<Body>();
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
            bodies[j] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
//            bodyArrayList.add(new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName));
        }
        return bodies;

    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);

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
            for (Body body : bodies) {
                xForces[ii] = body.calcNetForceExertedByX(bodies);
                yForces[ii] = body.calcNetForceExertedByY(bodies);
                ii++;
            }

            ii = 0;
            for (Body body : bodies) {
                body.update(dt, xForces[ii], yForces[ii]);
                ii++;
            }


            StdDraw.picture(0, 0, "images/starfield.jpg");

//            draw bodies
            for (Body body : bodies) {
                body.draw();
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