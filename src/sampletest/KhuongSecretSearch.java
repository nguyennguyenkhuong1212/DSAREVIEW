package sampletest;

public class KhuongSecretSearch {
    double xA;
    double yA;
    double vA;
    double xB;
    double yB;
    double vB;

    public KhuongSecretSearch(double xA, double yA, double vA, double xB, double yB, double vB) {
        this.xA = xA;
        this.yA = yA;
        this.vA = vA;
        this.xB = xB;
        this.yB = yB;
        this.vB = vB;
    }

    public double minTimeA(){
        return Math.abs(yA) / vA;
    }

    private double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public double timeFromA(double xZ){
        double distance = getDistance(xA, yA, xZ, 0);
        return distance / vA;
    }

    private double timeFromB(double xZ){
        double distance = getDistance(xB, yB, xZ, 0);
        return distance / vB;
    }

    public double pointC(){
        double epsilon = 0.000001;
        double minC = xA;
        double maxC = xB;
        while (maxC - minC > epsilon){
            double midC = (maxC + minC) / 2;
            double tA = timeFromA(midC);
            double tB = timeFromB(midC);
            if (tA < tB){
                minC = midC;
            }
            else {
                maxC = midC;
            }
        }
        return minC;
    }

    public static void main(String[] args) {
        KhuongSecretSearch secretSearch = new KhuongSecretSearch(-1, 1, 1, 1, -1, 0.5);
        System.out.println(secretSearch.minTimeA());
        System.out.println(secretSearch.timeFromA(0));
        System.out.println(secretSearch.pointC());
    }
}
