package calculators;

import java.util.List;

public class HighestScoreCalculator implements CalculationFunctionInterface {

	@Override
	public Double execute(List<Double> scores) {
		Double highest = 0d;
		for (Double nextScore : scores) {
			highest = Math.max(highest, nextScore);
		}
		return highest;
	}

}
