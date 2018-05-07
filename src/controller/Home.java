package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Home {
	
	// Global employee on application
	private Employee employee;
	
	// Get fields from window
	@FXML Label lblUsersName;
	@FXML Label lblQtdParceiros;
	@FXML Label lblQtdParceirosAtivos;
	@FXML Label lblQtdParcierosInativos;
	@FXML Label lblLucroAssinaturas;
	@FXML Label lblTotalGastosInternos;
	
	// Default constructor
	public Home(Employee employeeObj)
	{
		this.employee = employeeObj;
	}
	
	// Set some data into some field
	@FXML public void initialize() 
	{				
		// Show employee's name
		lblUsersName.setText(this.employee.getNome());
		
		// Show partners amount existents
		lblQtdParceiros.setText(String.valueOf(Partner.getPartnersAmount()));
		
		// Show active partners amount
		lblQtdParceirosAtivos.setText(String.valueOf(Partner.getActivePartnersAmount()));
		
		// Show inactive partners amount
		lblQtdParcierosInativos.setText(String.valueOf(Partner.getInactivePartnersAmount()));
		
		// Show profit earned on partners' subscriptions
		lblLucroAssinaturas.setText(String.valueOf(Subscription.getAllProfitValue()));
		
		// Show total of company expend's value
		lblTotalGastosInternos.setText(String.valueOf(Expend.getAllExpendValue()));
		
	}
	
	
	
	

}
