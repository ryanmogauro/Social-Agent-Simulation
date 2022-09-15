/**
 * Project: Social Agent Simulation
 * File: Landscape.java
 * Author: Ryan Mogauro
 * Date: 3/18/2022
 * Course: CS231
 */
import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {
	private int width;
	private int height; 
	private LinkedList<Agent> agents; 
	
	// a constructor that sets the width and height fields, and initializes the agent list.
	public Landscape(int w, int h) {
		this.height = h; 
		this.width = w; 
		this.agents = new LinkedList<Agent>(); 
	}
	
	//returns the height.
	public int getHeight() {
		return this.height; 
	}
	
	//returns the width.
	public int getWidth() {
		return this.width; 
	}
	
	//inserts an agent at the beginning of its list of agents.
	public void addAgent( Agent a ) {
		agents.addFirst(a);
	}
	
	//returns a String representing the Landscape. It can be as simple as indicating the number of Agents on the Landscape.
	public String toString() {
		return agents.size() + "";
	}
	
	//returns a list of the Agents within radius distance of the location x0, y0.
	public ArrayList<Agent> getNeighbors(double x0, double y0, double radius) {
		ArrayList<Agent> allAgents = this.agents.toArrayList();
        ArrayList<Agent> neighbors = new ArrayList<Agent>();
        
        for (int i = 0; i < this.agents.size(); i++) {
            Agent ag = allAgents.get(i);
            double x = ag.getX();
            double y = ag.getY();
            double xDist = (double)(x - x0);
            double yDist = (double)(y - y0);
            double distanceSquared = (xDist*xDist) + (yDist*yDist);

            if ((radius*radius) >= distanceSquared && (x0 != x && y0 != y)) {

                neighbors.add(ag);
            }
        }
        return neighbors;
    }
	
	// Calls the draw method of all the agents on the Landscape.
	public void draw(Graphics g) {
		for(Agent c: agents) {
			c.draw(g); 
		}
	}
	
	//calls updateState method on every cell on the landscape
	public void updateAgents() {
		ArrayList<Agent> agentAL= agents.toShuffledList(); 
		for(Agent c: agentAL){		
			c.updateState(this);
		}
	}
	
	//tests all methods to ensure they're working as intended
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Landscape scape = new Landscape(100,100);
		System.out.println("Should be 100: " + scape.getHeight()); 
		System.out.println("Should be 100: " + scape.getWidth()); 
		SocialAgent a1 = new SocialAgent(5,5,10);
		scape.addAgent(a1);
		SocialAgent a2 = new SocialAgent(10,10,10);
		scape.addAgent(a2);
		SocialAgent a3 = new SocialAgent(15,15,10);
		scape.addAgent(a3);
		SocialAgent a4 = new SocialAgent(20,20,10);
		scape.addAgent(a4);
		System.out.println(scape.getNeighbors(a1.getX(), a1.getY(), 25));

	}

}
