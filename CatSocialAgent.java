/**
 * Project: Social Agent Simulation
 * File: CatSocialAgent.java
 * Author: Ryan Mogauro
 * Date: 3/18/2022
 * Course: CS231
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class CatSocialAgent extends Agent{
	private int category; 
	private boolean moved;
	
	//calls the parent constructor and set the category.
	public CatSocialAgent(double x0, double y0, int cat) {
		super(x0,y0); 
		this.category = cat;
	}
	
	//returns the category value.
	public int getCategory() {
		return this.category; 
	}
	
	//returns a single character string indicating the category.
	public String toString() {
		return "" + this.category; 
	}
	//draws a circle of radius 5 (i.e. it fits in a 10x10 box) at the Agent's location. Different categories should have different colors, and each category will need a darker color (didn't move) and a lighter color (moved).
	public void draw(Graphics g) {
		
			int xVal = (int) this.getX(); 
			int yVal = (int) this.getY(); 
			int radius = 5; 
			if(this.getCategory() == 1) {
				if(moved) {
					g.setColor(Color.LIGHT_GRAY);
					g.fillOval(xVal, yVal, radius, radius);
				} else {
					g.setColor(Color.BLACK);
					g.fillOval(xVal, yVal, radius, radius);
				}
			} else if(this.getCategory() == 2) {
				if(moved) {
					g.setColor(Color.CYAN);
					g.fillOval(xVal, yVal, radius, radius);
				} else {
					g.setColor(Color.BLUE);
					g.fillOval(xVal, yVal, radius, radius);
				}
			} else {
				if(moved) {
					g.setColor(Color.RED);
					g.fillOval(xVal, yVal, radius, radius);
				} else {
					g.setColor(Color.MAGENTA);
					g.fillOval(xVal, yVal, radius, radius);
				}
				}
			}

	
	//updates state of a CatSocialAgnet based on given rules
	public void updateState(Landscape scape) {
		Random rand = new Random(); 
		int randInt = rand.nextInt(100); 
		// newFloat / newDouble here
		double randX = rand.nextDouble()*21 - 10; 
		double randY = rand.nextDouble()*21 - 10; 
		ArrayList<Agent> catSA = scape.getNeighbors(getX(), getY(),5); 
		int sameCat = 0; 
		int diffCat = 0; 
		int numNeighbors = catSA.size(); 
		
		for(Agent cat: catSA) {
			if(((CatSocialAgent)cat).getCategory() == this.getCategory()) {
				sameCat++; 
			} else {
				diffCat++; 
			}
		}
		
		if(sameCat > diffCat && numNeighbors >= 2) {
			if(randInt == 35) {
				this.setX(randX + this.getX());
				this.setY(randY + this.getY());
				this.moved = true; 
			} else {
				this.moved = false; 
			}
		} else {
			this.setX(randX + this.getX());
			this.setY(randY + this.getY());
			this.moved = true; 
		}
	}

	//tests methods to ensure they're working as intended
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatSocialAgent catSA = new CatSocialAgent(1.2,5.8, 2); 
		System.out.println("Should be 1.2: " + catSA.getX()); 
		System.out.println("Should be 5.8: " + catSA.getY()); 
		System.out.println("Should be 2: " + catSA.getCategory()); 
		System.out.println("Should be 2: " + catSA); 
	}

}
