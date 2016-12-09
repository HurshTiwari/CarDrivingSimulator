package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;
import renderEngine.DisplayManager;

public class Player extends Entity{
	
	private static final float RUN_SPEED = 20;
	private static final float TURN_SPEED = 160;
	
	public float currentSpeed = 0;
	public float currentTurnSpeed = 0;
	
	public Player(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);

	}
	
	public void move(){
		checkInputs();
		super.increaseRotation(0, currentTurnSpeed * DisplayManager.getFrameTimeSeconds(), 0);
		float distance = currentSpeed * DisplayManager.getFrameTimeSeconds();
		float dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
		float dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));
		super.increasePosition(dx, 0, dz);
	}
	
	private void checkInputs(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			this.currentSpeed += RUN_SPEED *DisplayManager.getFrameTimeSeconds();
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			this.currentSpeed -= RUN_SPEED*DisplayManager.getFrameTimeSeconds();
		}
		else{
			if(this.currentSpeed < 0)
				{
				this.currentSpeed += RUN_SPEED *DisplayManager.getFrameTimeSeconds();
				if(this.currentSpeed >0) this.currentSpeed =0;
				}
			else if(this.currentSpeed > 0)
				{this.currentSpeed -= RUN_SPEED*DisplayManager.getFrameTimeSeconds();
				if(this.currentSpeed <0) this.currentSpeed =0;
				}
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			this.currentTurnSpeed -=TURN_SPEED*DisplayManager.getFrameTimeSeconds();;
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			this.currentTurnSpeed +=TURN_SPEED*DisplayManager.getFrameTimeSeconds();;
		}
		else{
			this.currentTurnSpeed = 0;
		}
	}

}
