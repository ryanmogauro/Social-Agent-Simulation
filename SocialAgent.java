/**
 * Project: Social Agent Simulation
 * File: SocialAgent.java
 * Author: Ryan Mogauro
 * Date: 3/18/2022
 * Course: CS231
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class SocialAgent extends Agent{
	private int radius; 
	private boolean moved; 
	
	//constructor
	public SocialAgent(double x, double y, int radius) {
		super(x,y); 
		this.radius = radius;
	}
	
	//sets the cell's radius of sensitivity to the value of radius.
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
	//returns the cell's radius of sensitivity.
	public int getRadius() {
		return this.radius;
	}
	
	//draw method
	//lighter if was moved, darker otherwise
	public void draw(Graphics g) {
		int xVal =  (int) (this.getX() * 40);  
		int yVal = (int) (this.getY() * 40); 
		int radius = 5; 
		if(moved) {
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillOval(xVal, yVal, radius, radius);
	}
	
	//updates the state of a Social Agent 
	public void updateState(Landscape scape) {
		Random rand = new Random(); 
		int randInt = rand.nextInt(100); 
		// newFloat / newDouble here
		double randX = rand.nextDouble()*21 - 10; 
		double randY = rand.nextDouble()*21 - 10; 
		int numNeighbors = scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size(); 
		if(numNeighbors > 3) {
			if(randInt == 35) {
				this.setX(randX + this.getX());
				this.setY(randY + this.getY());
				this.moved = true; 
			} else {
				this.moved = false; 
			}
		} else {
			this.setX(randX);
			this.setY(randY);
			this.moved = true; 
		}
	}
	
	
	//tests methods to ensure they're working as intended
	public static void main(String[] args) {
		SocialAgent newSA = new SocialAgent(5,5,1); 
		System.out.println(newSA.getRadius()); 
		newSA.setRadius(2); 
		System.out.println(newSA.getRadius()); 
	}

}
