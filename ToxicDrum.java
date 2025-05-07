/**
 * ToxicDrum.java
 * Name: Timothy Jacot 041113276 
 * Course: CST8284 
 * Prof: Leanne Seaward 
 * Date: March 28th 2025 
 * Assignment: Assignment 2 
 * Files list: Drum_Test.java, DrumPanel.java, ToxicDrum.java, FlammableDrum.java, Drum.java
 * Toxic Drum class, initializing contents and toxicity level inside this class
 * 
 * @since due March 28th 2025
 * @version java 21.0.4
 * @author Timothy Jacot
 */
package domain;
import java.util.Random;

public class ToxicDrum extends Drum {
	public static final String CLASS_IA = "extremely hazardous";
	public static final String CLASS_IB = "highly hazardous";
	public static final String CLASS_II = "moderately hazardous";
	public static final String CLASS_III = "slightly hazardous";
	
	private String toxicity;
	//creating the array to display different contents of toxic drums, approved by Leanne Seaward
	private String contentsArray[] = {"Mercury", "Pesticides", "Radioactive waste","Sulfuric acid"};
	//creating array to display different classes of toxicity, approved by Leanne Seaward
	private static String toxicArray[] = {CLASS_IA, CLASS_IB, CLASS_II, CLASS_III};
	private static final Random random = new Random();
	//method to randomize the toxicity level of drums
	private static String GetToxicityLevel() {
		return toxicArray[random.nextInt(toxicArray.length)];
	}
	//method to randomize the contents of the drums
	private String GetDrumContents() {
		return contentsArray[random.nextInt(contentsArray.length)];
	}
	
	/**
	 * no args constructor
	 */
	public ToxicDrum() {
		super();
	}
	/**
	 * constructor 1 containing height, diameter
	 * @param height
	 * @param diameter
	 */
	public ToxicDrum(Float height, Float diameter) {
		super (height, diameter);
		this.toxicity = GetToxicityLevel();
	}
	/**
	 * constructor 2 containing height, diameter and contents
	 * @param height
	 * @param diameter
	 * @param contents
	 */
	public ToxicDrum(Float height, Float diameter, String contents) {
		super(height, diameter, contents);
		this.toxicity = GetToxicityLevel();
	}
	/**
	 * constructor 3 containing height, diameter, contents, and toxicity
	 * @param height
	 * @param diameter
	 * @param contents
	 * @param toxicity
	 */
	public ToxicDrum(Float height, Float diameter, String contents, String toxicity) {
		super(height, diameter, contents);
		this.toxicity = GetToxicityLevel();
	}
	public String getToxicity() {
		return toxicity;
	}
	public void setToxicity(String toxicity) {
		this.toxicity = toxicity;
	}
	@Override
	public String toString() {
		return super.toString() +"\nContents: " + GetDrumContents() +
				"\nToxicity level: " + GetToxicityLevel();
	}
	public float capacity() {
		Float diameter = getDiameter();
		Float height = getHeight();
		return (float) (Math.PI * Math.pow(diameter / 2, 2) * getHeight() * 0.75);
	}
}
