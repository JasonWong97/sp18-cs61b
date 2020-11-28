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

//        while (!in.isEmpty()) {
//            try {
//                in.readInt();
//            } catch (Exception e) {
//                try {
//                    d = in.readDouble();
//                    return d;
//                } catch (Exception e1) {
//                    System.out.println("Please enter double. ");
//                }
//                System.out.println("Please enter double. ");
//            }
//        }
        in.readInt();
        d = in.readDouble();
        return d;
    }

    public static Planet[] readPlanets(String path) {
        if (path.length() == 0) {
            System.out.println("Please supply a country as a command line argument.");
            System.out.println("For countries with spaces, use an underscore, e.g. South_Korea");
        }
        In in = new In(path);
        double d;
        int i = 0;

//        while (!in.isEmpty()) {
//            try {
//                i = in.readInt();
//            } catch (Exception e) {
//                try {
//                    d = in.readDouble();
//                    break;
//                } catch (Exception e1) {
//                    System.out.println("Please enter double. ");
//                }
//                System.out.println("Please enter double. ");
//            }
//        }
//

        i = in.readInt();
        d = in.readDouble();
        Planet[] planets = new Planet[i];
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
            planets[j] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
//            bodyArrayList.add(new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName));
        }
        return planets;

    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        int count_planets = planets.length;

//        double t=0;
        double[] xForces = new double[count_planets];
        double[] yForces = new double[count_planets];


        StdDraw.enableDoubleBuffering();
//
//        class MyThread extends Thread {
//            @Override
//            public void run() {
//                super.run();
//                StdAudio.play("audio/2001.mid");
//            }
//        }
//
//        MyThread myThread = new MyThread();
//        myThread.start();


        for (int t = 0; t < T; t++) {
            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
//            calculate the xForeces and yForeces arryas
            int ii = 0;
            for (Planet p : planets) {
                xForces[ii] = p.calcNetForceExertedByX(planets);
                yForces[ii] = p.calcNetForceExertedByY(planets);
                ii++;
            }

            ii = 0;
            for (Planet p : planets) {
                p.update(dt, xForces[ii], yForces[ii]);
                ii++;
            }


            StdDraw.picture(0, 0, "images/starfield.jpg");

//            draw planets
            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

        StdAudio.close();

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }


    }
}