package com.dharmik.patterns.strategy;

import java.util.Scanner;


public class StrategyDemo1_RosterAdminModule {

	//web.xml starts
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _Context_Controller().go();
	}

}

interface IAdminCardType{
	public String display();
}
class _Context_Controller{
	//getting request parameter
	public void go(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input e/t/o..");
		String type = scanner.next();
		ServiceLayer serivces = new ServiceLayer();
		IAdminCardType cardType = serivces.getCardType(type);
		display(cardType);
		scanner.close();
	}
	
	//this display process will always use a card type
	public void display(IAdminCardType cardType){
		System.out.println(cardType.display());
	}
	
}

class ServiceLayer{
	public IAdminCardType getCardType(String type){
		return AdminCardTypeFatory.getCardType(type);
	}
}

class EmployeeCard implements IAdminCardType{
	public String display() {
		return "Employee specific display method";
	}
}
class TerritoryCaard implements IAdminCardType{
	public String display() {
		return "Territory with additional diaply";
	}
}

//added extra after the deployment--maintance
class OrgaanizationCard implements IAdminCardType{
	public String display() {
		return "Organizzation only one field";
	}
}

class AdminCardTypeFatory{
	static IAdminCardType getCardType(String type){
		if("E".equalsIgnoreCase(type)){
			return new EmployeeCard();
		}//changes done in this method only- factory method only
		else if("O".equalsIgnoreCase(type)){
			return new OrgaanizationCard();
		}
		else{
			return new TerritoryCaard();
		}
	}
}