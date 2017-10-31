package com.dharmik.patterns.state;

public class GumballMachine_HF_StatePattern {

	public static void main(String[] args) {
		GumballMachine machine = new GumballMachine(2);
		machine.insertQuarter();
		machine.turnCrank();
		System.out.println(machine);
		machine.insertQuarter();
		machine.turnCrank();
		System.out.println(machine);

	}

}

/**
 * This is the main core interface which will be implemented by all the
 * different state based on localized logic each state has.
 */
interface GumballState {
	void insertQuarter();

	void ejectQuarter();

	void turnCrank();

	void dispense();
}

/**
 * this class implements all the action taken by the user/actor
 * eject, insert and turn the crank. But the dispense action which 
 * is in the interface is not called by the user but it is internal
 * act, so we do not have dispense function in this class
 */
class GumballMachine {
	
	private GumballState soldOutState;
	private GumballState noQuarterState;
	private GumballState hasQuarterState;
	private GumballState soldState;

	private GumballState state = soldOutState;
	int count = 0;

	public GumballMachine(int numberGumballs) {
		//creating all the states
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		} else {
			state = soldOutState;
		}
	}

	//we delegate each action to the current state of the machine
	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		//when the crank is turned with a quarter in it, the state is
		//changed to sold state. The next line is called on sold state
		state.turnCrank();
		state.dispense();
	}

	//this is the helper method which is keeps the count of the gumballs,
	//again this is not caalled by the actor/user
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}

	public GumballState getState() {
		return state;
	}

	public void setState(GumballState state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public GumballState getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(GumballState soldOutState) {
		this.soldOutState = soldOutState;
	}

	public GumballState getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(GumballState noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public GumballState getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(GumballState hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public GumballState getSoldState() {
		return soldState;
	}

	public void setSoldState(GumballState soldState) {
		this.soldState = soldState;
	}
}

class NoQuarterState implements GumballState {

	GumballMachine gumballMachine;

	/*
	 * we get the reference to the gumball machine instance through the
	 * constructor. This is used to transition the machine to different states.
	 */
	NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		//after inserting amount, the state of the machine will be
		//changed to hasQuarter state
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	public void turnCrank() {
		System.out.println("You turned the crank, but there is no qurter");
	}

	public void dispense() {
		System.out.println("You need to pay first");
	}
	
	public String toString() {
		return "waiting for quarter";
	}
}

class HasQuarterState implements GumballState {

	GumballMachine gumballMachine;
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("You cannot insert again.");
	}

	public void ejectQuarter() {
		System.out.println("Quarter returned..huh..");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	public void turnCrank() {
		System.out.println("You turned..");
		/*
		 * considering the positive scenario - from hasQuarterState,
		 * turning the crank will move to sold state. And turnCrank
		 * method internally calls the dispense method on the current state,
		 * which is not changed to sold state inside the turnCrank method.
		 */
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	public void dispense() {
		System.out.println("No gumball dispensed");
	}
	
}

class SoldOutState implements GumballState {

	public SoldOutState(GumballMachine gumballMachine) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		
	}
	
}

class SoldState implements GumballState {
	
	GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("Please wait your gumball is coming out");
	}

	public void ejectQuarter() {
		System.out.println("Sorry you have already turned the crank now wait for the gumball");
	}

	public void turnCrank() {
		System.out.println("Turning twice..laalchi..ek hi milega");
	}

	public void dispense() {
		/*
		 * real logic begins here, we are in the soldState means that the customer has already
		 * paid the quarter.The mchine will release the ball.
		 */
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() > 0){
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}
		else{
			System.out.println("Machine is out of Gumball");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
	
}