package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private float distFromPlayer = 25;
	private float AngleAroundPlayer = 0;
	
	private Vector3f position = new Vector3f(20,2000,0);
	private float pitch = 20;
	private float yaw;
	private float roll;
	
	private Player player;
	public Camera(Player player){
		this.player = player;
	}
	
	private void calculateCameraPosition(float hdist , float vdist){
		position.y = player.getPosition().y + vdist;
		float theta = AngleAroundPlayer + player.getRotY(); 
		position.x = (float) (player.getPosition().x - hdist * Math.sin(Math.toRadians(theta))) 	;
		position.z = (float) (player.getPosition().z - hdist * Math.cos(Math.toRadians(theta))) 	;
	}
	
	public void move(){

		calculateZoom();
		calculatePitch();
		calculateAngleAroundPlayer();
		float horizontalDistance = calcHorizontalDistanceFromPlayer();
		float verticalDistance = calcVerticalDistanceFromPlayer();
		calculateCameraPosition(horizontalDistance, verticalDistance);
		this.yaw = 180 - (AngleAroundPlayer + player.getRotY());
		
	}

	private float calcHorizontalDistanceFromPlayer(){
		return (float) (distFromPlayer * Math.cos(Math.toRadians(pitch)));
	}
	private float calcVerticalDistanceFromPlayer(){
		return (float) (distFromPlayer * Math.sin(Math.toRadians(pitch)));
	}
	
	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	};
	
	private void calculateZoom(){
		float zoomLevel = Mouse.getDWheel() * 0.1f;
		distFromPlayer-=zoomLevel;
	}
	
	
	private void calculatePitch(){
		
		if(Mouse.isButtonDown(1))
		{
			float pitchChange = Mouse.getDY() *0.1f;
			pitch-=pitchChange;
		}
	}
	
	private void calculateAngleAroundPlayer(){
		
		if(Mouse.isButtonDown(0))
		{
			float angleChange = Mouse.getDX() *0.3f;
			AngleAroundPlayer -= angleChange;
		}
	}

}
