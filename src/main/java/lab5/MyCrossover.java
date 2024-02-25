package lab5;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int numberOfCrossoverPoints, Random random) {
        ArrayList children = new ArrayList();

        for (int i = 0; i < numberOfCrossoverPoints; i++) {
            double a = random.nextDouble();
            double[] p_new = new double[p1.length];
            for (int j = 0; j < p1.length; j++) {
                p_new[j] = a * p1[j] + (1 - a) * p2[j];
            }
            children.add(p_new);
        }
        return children;
    }
}
