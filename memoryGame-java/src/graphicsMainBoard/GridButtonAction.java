package graphicsMainBoard;

import memoryGame.Brick;

public class GridButtonAction {
	
	private int x, y; //tile to be turned
	boolean buttonPressed = false;
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void actionPreformed(){
		buttonPressed = false;
	}
	
	public boolean checkForAction(){
		return buttonPressed;
	}
	

	public void preformAction(int x, int y, Brick brick) {
		
		this.x = x;
		this.y = y;
		buttonPressed = true;
		
	}
}
