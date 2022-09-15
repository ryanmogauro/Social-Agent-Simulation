/**
 * Project: Social Agent Simulation
 * File: Agent.java
 * Author: Ryan Mogauro
 * Date: 3/18/2022
 * Course: CS231
 */
import java.awt.Graphics;
public class Agent {
	private double xPos; 
	private double yPos; 
	
	//a constructor that sets the position.
	public Agent(double x0, double y0) {
		this.xPos = x0; 
		this.yPos = y0; 
	}
	
	//returns the x position.
	public double getX() {
		return this.xPos; 
	}
	
	//returns the y position.
	public double getY() {
		return this.yPos; 
	}
	
	//sets the x position.
	public void setX( double newX ) {
		this.xPos = newX; 
	}
	
	//sets the y position.
	public void setY( double newY ) {
		this.yPos = newY; 
	}
	
	//returns a String containing the x and y positions, e.g. "(3.024, 4.245)".
	public String toString() {
		return ("(" + this.xPos + ", " + this.yPos + ")"); 
	}
	
	//does nothing, for now.
	public void updateState( Landscape scape ) {
		
	}
	
	//does nothing, for now.
	public void draw(Graphics g) {
		
	}
	
	//tests all methods to ensure they're working as intended
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agent testAgent = new Agent(3.5,10); 
		System.out.println(testAgent); 
		testAgent.setX(10); 
		testAgent.setY(3.5);
		System.out.println("Should be (10.0, 3.5): " + testAgent); 
		testAgent.setX(4.1); 
		testAgent.setY(6.76);
		System.out.println("should be 4.1: " + testAgent.getX()); 
		System.out.println("should be 6.76: " + testAgent.getY()); 
	
	}
}
