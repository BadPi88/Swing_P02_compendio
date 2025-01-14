/**
 * Ventana.java
 * 13 nov 2024 9:30:50
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * 
 */
public class Ventana extends JFrame implements ActionListener {
	private JMenuBar barraMenu;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, bajaReserva, altaReserva, acercaDe;
	private JButton btnAltaReserva, btnBajaReserva;

	public Ventana() {
		super("Swing Practica02 Miguel Martin Gil");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gestion Hotel Aquamarine");
		this.setLayout(new BorderLayout());

		// Configuración pantalla -----------------------------
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		this.setSize(anchoPantalla / 2, altoPantalla / 2);
		this.setLocation(anchoPantalla / 4, altoPantalla / 4);

		// Fondo
		this.getContentPane().setBackground(new Color(127, 255, 212)); // Color Aquamarine

		// Barra de menú
		barraMenu = new JMenuBar();

		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		ayuda = new JMenu("Ayuda");

		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		archivo.add(salir);

		altaReserva = new JMenuItem("Alta Reservas");
		altaReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.SHIFT_DOWN_MASK));
		altaReserva.addActionListener(this);

		bajaReserva = new JMenuItem("Baja Reservas");
		bajaReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.SHIFT_DOWN_MASK));
		bajaReserva.addActionListener(this);

		acercaDe = new JMenuItem("Acerca de...");
		acercaDe.addActionListener(this);

		barraMenu.add(archivo);
		barraMenu.add(registro);
		barraMenu.add(ayuda);

		registro.add(altaReserva);
		registro.add(bajaReserva);
		ayuda.add(acercaDe);
		archivo.add(salir);

		this.setJMenuBar(barraMenu);

		// Botones redimensionados
		ImageIcon imagenAlta = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/nueva_alta.png"))
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		btnAltaReserva = new JButton(imagenAlta);
		btnAltaReserva.setToolTipText("Dar de alta una nueva Reserva");
		btnAltaReserva.addActionListener(this);

		ImageIcon imagenBaja = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/baja_cliente.png"))
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		btnBajaReserva = new JButton(imagenBaja);
		btnBajaReserva.setToolTipText("Dar de baja una Reserva existente");
		btnBajaReserva.addActionListener(this);

		// Logo redimensionado
		ImageIcon imagenLogo = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/logo_hotel.png"))
				.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
		JLabel logoHotel = new JLabel(imagenLogo);
		logoHotel.setToolTipText("Hotel Aquamarine");

		// Añadir componentes al BorderLayout
		// Botón arriba
		this.add(btnAltaReserva, BorderLayout.NORTH);
		// Botón abajo
		this.add(btnBajaReserva, BorderLayout.SOUTH);
		this.add(logoHotel, BorderLayout.CENTER);

		// icono ventana
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/logo_hotel.png"));
		setIconImage(icono.getImage());

		// !!
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salir) {
			System.exit(0);
		}
		if (e.getSource() == altaReserva || e.getSource() == btnAltaReserva) {

			VentanaDialogo miVentanaDialog = new VentanaDialogo(this, true);
			miVentanaDialog.setVisible(true);
		}
		if (e.getSource() == bajaReserva || e.getSource() == btnBajaReserva) {

			JOptionPane.showMessageDialog(this, "Esta funcion no está desarrollada hasta el momento.",
					"Funcion en desarrollo", JOptionPane.WARNING_MESSAGE);
		}
		if (e.getSource() == acercaDe) {
			JOptionPane.showMessageDialog(this,
					"Gestión Hotel Aquamarine v1.0 Desarrollado por Miguel Martin Gil 2024 Hotel Aquamarine",
					"Acerca de", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
