/**
 * FlammableDrum.java
 * Name: Timothy Jacot 041113276 
 * Course: CST8284 
 * Prof: Leanne Seaward 
 * Date: March 28th 2025 
 * Assignment: Assignment 2 
 * Files list: Drum_Test.java, DrumPanel.java, ToxicDrum.java, FlammableDrum.java, Drum.java
 * Flammable Drum class, initializing contents and flashpoint, in Celsius.
 * 
 * @since due March 28th 2025
 * @version java 21.0.4
 * @author Timothy Jacot
 */
package domain;
import java.util.Random;

/**
 * A class representing a flammable drum container that extends the basic Drum class.
 * This type of drum contains flammable liquids with specific flashpoint levels, in Celsius.
 */
public class FlammableDrum extends Drum {
	//creating flashpoint float
	private Float flashpoint;
	//creating contents array to display new values for each drum, approved by Leanne Seaward
	private String contentsArray[] = {"Gasoline", "Acetone", "Isopropyl alcohol"};
	
	//constructor 1
	public FlammableDrum() {}
	/**constructor 2
	 * Purpose: constructor with height and diameter parameters
	 * @param height
	 * @param diameter
	 */
	public FlammableDrum(Float height, Float diameter) {
		super(height, diameter);
		this.flashpoint = generateRandomFloat(50,300);
	}
	/**
	 * creating the drum content array method, to output different contents every drum
	 * @return returns different array numbers
	 */
	private String GetDrumContents() {
		return contentsArray[random.nextInt(contentsArray.length)];
	}
	Random random = new Random();
	/**
	 * constructor containing minimum and maximum temperatures for flashpoint
	 * @param minTemp
	 * @param maxTemp
	 * @return returns calculations for flashpoint method
	 */
	private Float generateRandomFloat(float minTemp, float maxTemp) {
		return minTemp + (maxTemp - minTemp) * random.nextFloat();
	}
	/**
	 * chained constructor containing height, diameter, contents
	 * @param height
	 * @param diameter
	 * @param contents
	 */
	public FlammableDrum(Float height, Float diameter, String contents) {
		super(height, diameter, contents);
		this.flashpoint = generateRandomFloat(50,300);
	}
	/**
	 * chained constructor containing height, diameter, contents and flashpoint
	 * @param height
	 * @param diameter
	 * @param contents
	 * @param flashpoint
	 */
	public FlammableDrum(Float height, Float diameter, String contents, Float flashpoint) {
		this.flashpoint = generateRandomFloat(50,300);
	}
	public Float getFlashpoint() {
		return flashpoint;
	}
	public void setFlashpoint(Float flashpoint) {
		this.flashpoint = flashpoint;
	}
	@Override
	public String toString() {
		return super.toString() + String.format("\ncontents: %s", 
				GetDrumContents()) + 
				String.format("\nflashpoint: %.1f", flashpoint);
	}
	@Override
	public float capacity() {
		Float diameter = getDiameter();
		Float height = getHeight();
		return (float) (Math.PI * Math.pow(getDiameter() / 2, 2) * getHeight());
	}
}
