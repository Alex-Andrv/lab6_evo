package lab5;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    int iters = 0;

    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!
        for (double[] individual: population) {
            for (int i = 0; i < individual.length; i++) {
                if (iters > 5000) {
                    if (random.nextDouble() < 1. / individual.length) {
                        double a = iters / 50000.;
                        individual[i] = individual[i] + (1 - a) * random.nextGaussian();
                    }
                } else {
                    if (random.nextDouble() < 1. / individual.length) {
                        double a = iters / 10000.;
                        individual[i] = individual[i] * a + (1 - a) * (random.nextDouble() * 10 - 5);
                    }
                }
            }
        }
        iters += 1;

        //result population
        return population;
    }
}
