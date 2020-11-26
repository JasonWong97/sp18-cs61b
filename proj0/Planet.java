/*
 * @Author: Weng Jiacheng
 * @Date: 2020-11-25 14:58:20
 * @LastEditors: Weng Jiacheng
 * @LastEditTime: 2020-11-25 15:07:46
 * @FilePath: /undefined/Users/wengjiacheng/Desktop/CS61B/code/ex1/Body.java
 */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        return Math.sqrt((this.xxPos - b.xxPos) * (this.xxPos - b.xxPos) +
                (this.yyPos - b.yyPos) * (this.yyPos - b.yyPos));

    }

    public double calcForceExertedBy(Planet b) {
        return G * mass * b.mass / Math.pow(calcDistance(b), 2);
    }

    public double calcForceExertedByX(Planet b) {
////        positive force in x axis
//        if (b.xxPos>xxPos){
        return calcForceExertedBy(b) * (b.xxPos - xxPos) / calcDistance(b);

    }

    public double calcForceExertedByY(Planet b) {
        return calcForceExertedBy(b) * (b.yyPos - yyPos) / calcDistance(b);

    }

    public double calcNetForceExertedByX(Planet[] bodies) {
        double netForceX = 0;
        for (Planet p : bodies) {
            if (!this.equals(p)) {
                netForceX += calcForceExertedByX(p);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] bodies) {
        double netForceY = 0;
        for (Planet p : bodies) {
            if (!this.equals(p)) {
                netForceY += calcForceExertedByY(p);
            }
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY) {
        xxVel += dt * fX / mass;
        yyVel += dt * fY / mass;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}