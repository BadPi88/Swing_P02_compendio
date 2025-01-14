/**
 * PanelNinios.java
 * 16 nov 2024 12:26:41
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */
public class PanelNinios extends JPanel implements ChangeListener, FocusListener {

	private JLabel edadNiniosText, extrasText;
	static JSpinner edadNinios;
	static JTextField extras;
	private SpinnerModel valores;

	public PanelNinios() {

		edadNiniosText = new JLabel("Edad de los Niños: ");
		valores = new SpinnerNumberModel(0, 0, 14, 1);
		edadNinios = new JSpinner(valores);
		edadNinios.addChangeListener(this);

		extrasText = new JLabel("Extras: ");
		extras = new JTextField();
		extras.setEditable(false);

		Box cajaH1 = Box.createHorizontalBox();
		Box cajaH2 = Box.createHorizontalBox();
		Box cajaVertical = Box.createVerticalBox();

		cajaH1.add(edadNiniosText);
		cajaH1.add(edadNinios);

		cajaVertical.add(cajaH1);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH2.add(extrasText);
		cajaH2.add(extras);

		cajaVertical.add(cajaH2);
		cajaVertical.add(Box.createVerticalStrut(10));

		this.add(cajaVertical);
	}

	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() == edadNinios) {

			if ((int) edadNinios.getValue() >= 0 && (int) edadNinios.getValue() <= 3) {
				extras.setText("Cuna");
			} else if ((int) edadNinios.getValue() >= 4 && (int) edadNinios.getValue() <= 10) {
				extras.setText("Cama supletoria pequeña");
			} else if ((int) edadNinios.getValue() >= 11) {
				extras.setText("cama supletoria normal");

			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
