public class TestBody {
    public static void main(String[] args) {
        Body a = new Body(1, 2, 3, 4, 5, "jupiter.gif");
        Body b = new Body(6, 7, 8, 9, 10, "jupiter.gif");
        System.out.println(a.calcDistance(b));
        System.out.println(a.calcForceExertedBy(b));
        System.out.println(a.calcForceExertedByX(b));
        System.out.println(a.calcForceExertedByY(b));
        Body[] bodies = new Body[]{a, b};
        System.out.println(a.calcNetForceExertedByX(bodies));
        System.out.println(a.calcNetForceExertedByY(bodies));
        a.update(1, 2, 3);
        String s = "fsdf";

    }
}