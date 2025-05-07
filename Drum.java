/**
 * Drum.java
 * Name: Timothy Jacot 041113276 
 * Course: CST8284 
 * Prof: Leanne Seaward 
 * Date: March 28th 2025 
 * Assignment: Assignment 2 
 * Files list: Drum_Test.java, DrumPanel.java, ToxicDrum.java, FlammableDrum.java, Drum.java
 * abstract Drum class, creating toString() method and abstract capacity() method.
 * 
 * @since due March 28th 2025
 * @version java 21.0.4
 * @author Timothy Jacot
 */
package domain;

/**
 * Sample Drum class for test purposes.
 * This class does not implement the UML class diagram specifications.
 * You must modify this class to adhere to the UML specs.
 * Hint: the Drum class contains an abstract method, "capacity()".
 */
public abstract class Drum {
	
	private Float height = 0.0f;
	private Float diameter = 0.0f;
	private String contents = "UNKNOWN";
	/**
	 * default no args constructor
	 */
	public Drum() {}
	/**
	 * constructor 1 with height and diameter
	 * @param height
	 * @param diameter
	 */
	public Drum(Float height, Float diameter) {
		this.height = height;
		this.diameter = diameter;
	}
	/**
	 * constructor 2 with height, diameter and contents
	 * @param height
	 * @param diameter
	 * @param contents
	 */
	public Drum(Float height, Float diameter, String contents) {
		this.height = height;
		this.diameter = diameter;
		this.contents = contents;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public float getDiameter() {
		return diameter;
	}
	public void setDiameter(Float diameter) {
		this.diameter = diameter;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	/**
	 * abstract capacity method to be used across entire program
	 * @return null
	 */
	public abstract float capacity();
	/**
	 * toString method to display all height, diameter, contents and capacity
	 */
	public String toString()	{
		return String.format("Drum: Height: %.1f", height,
			"Diameter: %.1f", diameter,
			"Contents: %s", contents,
			"Capacity: %.3f", capacity());
	}

}
