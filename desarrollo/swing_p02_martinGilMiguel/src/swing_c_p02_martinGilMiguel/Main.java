/**
 * Main.java
 * 13 nov 2024 9:31:23
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.Dimension;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setMinimumSize(new Dimension(ventana.getWidth(), ventana.getHeight()));

	}

}
