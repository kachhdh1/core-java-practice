package com.dharmik.patterns.strategy;

import java.util.Scanner;

/**
 * This class is used to display training on home page page based on user input.
 * User can enter any strategy to input training list like (most views, most
 * subscribers, creation date, most activity, least amount of comments,
 * whatever)
 * 
 * @author Dharmik
 *
 */
public class StrategyDemo2_SMDPTrainingList {
int m=0;
	public static void main(String[] args) {
		new _Context_Controller1().go();
		//System.out.println(m);
	}

}

interface ITrainingOrder {
	public String trainingOrder();
}

class _Context_Controller1 {
	// getting request parameter
	public void go() {
		Scanner scanner = new Scanner(System.in);
		System.out
				.println("Input Training Order...Date/Most Viewed/Most Active");
		String type = scanner.next();
		ITrainingOrder trainingOrder = TrainingOrderTypeFatory
				.getTrainingOrderType(type);
		displayTraining(trainingOrder);
		scanner.close();
	}

	// this display process will always use a card type
	public void displayTraining(ITrainingOrder cardType) {
		System.out.println(cardType.trainingOrder());
	}

}

class ServiceLayer1 {
	public ITrainingOrder getCardType(String type) {
		return TrainingOrderTypeFatory.getTrainingOrderType(type);
	}
}

class MostViewedTraining implements ITrainingOrder {

	public String trainingOrder() {
		return "Displaying Most viewed training";
	}
}

class DateOrderTraining implements ITrainingOrder {
	public String trainingOrder() {
		return "Displaying By Date Order training";
	}
}

// added extra after the deployment--maintance
class MostActiveTraining implements ITrainingOrder {
	public String trainingOrder() {
		return "Most Active trainings";
	}
}

class TrainingOrderTypeFatory {
	static ITrainingOrder getTrainingOrderType(String type) {
		if ("D".equalsIgnoreCase(type)) {
			return new DateOrderTraining();
		}// chaanges done in this method only- factory method only
		else if ("MA".equalsIgnoreCase(type)) {
			return new MostActiveTraining();
		} else {
			return new MostViewedTraining();
		}
	}
}
