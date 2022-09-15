/**
 * Project: Social Agent Simulation
 * File: SocialAgentSimulation.java
 * Author: Ryan Mogauro
 * Date: 3/18/2022
 * Course: CS231
 */
import java.util.Random;

public class SocialAgentSimulation {
	
	//Creates a social agent simulation 
	//adds 200 agents to the agents linked list and calls update state on each agent
	//also visualizes the landscape
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 Landscape scape = new Landscape(500,500);
	     Random gen = new Random();
	     LandscapeDisplay display = new LandscapeDisplay(scape);

	   
	     for(int i = 0; i < 200; i++) {
	    	 scape.addAgent(new SocialAgent(gen.nextDouble() * 500, gen.nextDouble() * 500, 1));
	     }
	     while(true) {
				scape.updateAgents(); 
				display.repaint(); 
				Thread.sleep(250);
			}
	}
}
