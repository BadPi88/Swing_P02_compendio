/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usabilidad_p02c_martinGilMiguel;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Isabel Cayuela Pérez
 */
public class CompraProductosModificado extends javax.swing.JDialog {

	/**
	 * Creates new form CompraProductos
	 */
	public CompraProductosModificado(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image miIcono = miPantalla.getImage(getClass().getResource("img/logoIes.png"));
		this.setIconImage(miIcono);
		initComponents();

		ImageIcon imagen = new ImageIcon(getClass().getResource("img/EJ01_02.jpg"));
		Icon icono = new ImageIcon(
				imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		lblImagen.setIcon(icono);
		this.repaint();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		cbArticulos = new javax.swing.JComboBox<>();
		lblImagen = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtProductos = new javax.swing.JTable();
		btnAgregar = new javax.swing.JButton();
		JButton btnEliminar = new JButton();
		spnCantidad = new javax.swing.JSpinner();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtCodigo = new javax.swing.JTextField();
		txtNombre = new javax.swing.JTextField();
		txtApellido1 = new javax.swing.JTextField();
		txtApellido2 = new javax.swing.JTextField();
		txtCalle = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtNumero = new javax.swing.JFormattedTextField();
		jLabel8 = new javax.swing.JLabel();
		txtCP = new javax.swing.JFormattedTextField();
		jLabel9 = new javax.swing.JLabel();
		txtLocalidad = new javax.swing.JTextField();
		btnAceptar = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		cbMostrarImagenesMenu = new javax.swing.JCheckBoxMenuItem();
		cbGuardar = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();

		jLabel1.setText("jLabel1");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		cbArticulos.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Adorno de Papá Noel", "Muñeco de nieve", "Campanas navideñas", "Arbol de navidad" }));
		cbArticulos.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbArticulosItemStateChanged(evt);
			}
		});

		lblImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

		// Solucionamos el problema de poder editar las celdas haciendo que no sean
		// editables
		jtProductos.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "PRODUCTO", "CANTIDAD", "PRECIO" }) {
			private static final long serialVersionUID = 1L;
			boolean[] editable = new boolean[] { false, false, false // cada uno por columna que tenga la tabla.
			 };
			// se tiene que llamar asi porque es DefaultTable es un método que el sistema llama cada vez que el usuario intenta editar una celda de la tabla.
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return editable[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jtProductos);

		btnAgregar.setText("AGREGAR");
		btnAgregar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAgregarActionPerformed(evt);
			}
		});
		// Agrego el listener al boton Eliminar al que mas tarde añadiremos la
		// funcionalidad en btnEliminarActionPerformed.
		btnEliminar.setText("ELIMINAR");
		btnEliminar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt2) {
				btnEliminarActionPerformed(evt2);
			}
		});

		spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

		jLabel2.setText("DNI:");

		jLabel3.setText("Nombre:");

		jLabel4.setText("1er. Apellido:");

		jLabel5.setText("2do. Apellido:");

		jLabel6.setText("Calle:");

		jLabel7.setText("Nunmero:");

		jLabel8.setText("CP:");

		jLabel9.setText("Localidad:");

		btnAceptar.setText("ACEPTAR");
		btnAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAceptarActionPerformed(evt);
			}
		});

		jMenu1.setText("Acciones");

		cbMostrarImagenesMenu.setSelected(true);
		cbMostrarImagenesMenu.setText("Mostrar imágenes");
		cbMostrarImagenesMenu.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbMostrarImagenesMenuItemStateChanged(evt);
			}
		});
		cbMostrarImagenesMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbMostrarImagenesMenuActionPerformed(evt);
			}
		});
		jMenu1.add(cbMostrarImagenesMenu);

		cbGuardar.setText("Guardar");
		cbGuardar.addActionListener(new java.awt.event.ActionListener() {
			// añadimos el mensaje de datos guardados correctamente
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
			}
		});
		jMenu1.add(cbGuardar);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Salir");
		jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu2MouseClicked(evt);
			}
		});
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(38, 38, 38)
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
										.createSequentialGroup().addGap(2, 2, 2).addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING).addComponent(btnAceptar,
														javax.swing.GroupLayout.PREFERRED_SIZE, 170,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(spnCantidad,
																javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnAgregar,
																javax.swing.GroupLayout.PREFERRED_SIZE, 170,
																javax.swing.GroupLayout.PREFERRED_SIZE))

												// btnEliminar agregado al layout en el grupo horizontal. Primera
												// solucion Control y libertad de usuario
												.addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)

														.addComponent(cbArticulos, 0, 239, Short.MAX_VALUE)
														.addComponent(
																lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))))
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtCodigo))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel5)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addComponent(jLabel6)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtCalle))
												.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
																165, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(jLabel4)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtApellido1,
																javax.swing.GroupLayout.PREFERRED_SIZE, 144,
																javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(jLabel7)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(jLabel8)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtCP).addGap(18, 18, 18).addComponent(jLabel9)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 351,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(44, 44, 44)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(34, 34, 34)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4)
								.addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
						.addComponent(jLabel6)
						.addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9)
								.addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8).addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(26, 26, 26)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
				.addGap(18, 18, 18)
				.addComponent(cbArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				// btn Eliminar display en el eje vertical.
				.addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void cbMostrarImagenesMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbMostrarImagenesMenuActionPerformed
		ImageIcon imagen = new ImageIcon();
		Icon icono;

		if (!this.cbMostrarImagenesMenu.getState()) {
			imagen = new ImageIcon(getClass().getResource("img/EJ01_01.jpg"));
			icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
					Image.SCALE_DEFAULT));
			lblImagen.setIcon(icono);
			this.repaint();
		} else {
			switch (cbArticulos.getSelectedIndex()) {
			case 0:
				imagen = new ImageIcon(getClass().getResource("img/EJ01_02.jpg"));
				break;
			case 1:
				imagen = new ImageIcon(getClass().getResource("img/EJ01_03.jpg"));
				break;
			case 2:
				imagen = new ImageIcon(getClass().getResource("img/EJ01_04.jpg"));
				break;
			case 3:
				imagen = new ImageIcon(getClass().getResource("img/EJ01_05.jpg"));
				break;
			}
			icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
					Image.SCALE_DEFAULT));
			lblImagen.setIcon(icono);
			this.repaint();
		}
	}// GEN-LAST:event_cbMostrarImagenesMenuActionPerformed

	private void cbArticulosItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbArticulosItemStateChanged
		ImageIcon imagen = new ImageIcon();
		switch (cbArticulos.getSelectedIndex()) {
		case 0:
			imagen = new ImageIcon(getClass().getResource("img/EJ01_02.jpg"));
			break;
		case 1:
			imagen = new ImageIcon(getClass().getResource("img/EJ01_03.jpg"));
			break;
		case 2:
			imagen = new ImageIcon(getClass().getResource("img/EJ01_04.jpg"));
			break;
		case 3:
			imagen = new ImageIcon(getClass().getResource("img/EJ01_05.jpg"));
			break;
		}

	}// GEN-LAST:event_cbArticulosItemStateChanged

	private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
		DefaultTableModel dtm = (DefaultTableModel) jtProductos.getModel();
		switch (cbArticulos.getSelectedIndex()) {
		case 0:
			dtm.addRow(new Object[] { "Adorno de Papá Noel", spnCantidad.getValue(), "2.25" });
			break;
		case 1:
			dtm.addRow(new Object[] { "Muñeco de nieve", spnCantidad.getValue(), "1.10" });
			break;
		case 2:
			dtm.addRow(new Object[] { "Campanas navideñas", spnCantidad.getValue(), "1.99" });
			break;
		case 3:
			dtm.addRow(new Object[] { "Árbol de Navidad", spnCantidad.getValue(), "15.50" });
			break;
		}
		JOptionPane.showMessageDialog(null, "Artículo agregado.");
	}// GEN-LAST:event_btnAgregarActionPerformed

	private void cbMostrarImagenesMenuItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbMostrarImagenesMenuItemStateChanged

	}// GEN-LAST:event_cbMostrarImagenesMenuItemStateChanged

	/// ----------------Se añade el metodo para eliminar
	/// articulos--------------------------------------------------------------------------------------------------------------
	private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
		// Obtiene el modelo de la tabla para manipular sus filas
		DefaultTableModel dtm = (DefaultTableModel) jtProductos.getModel();
		// Obtiene la fila seleccionada en la tabla
		int filaSeleccionada = jtProductos.getSelectedRow();

		// Verifica si hay una fila seleccionada
		if (filaSeleccionada != -1) {
			// Elimina la fila seleccionada del modelo de la tabla
			dtm.removeRow(filaSeleccionada);
			// Muestra un mensaje de confirmación
			JOptionPane.showMessageDialog(null, "Artículo eliminado.");
		} else {
			// Muestra un mensaje de advertencia si no se seleccionó ninguna fila
			JOptionPane.showMessageDialog(null, "Seleccione un artículo para eliminarlo.");
		}
	}// GEN-LAST:event_btnEliminarActionPerformed

	private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAceptarActionPerformed
		String errores = "";
		String codigo = txtCodigo.getText().toUpperCase();
		String nombre = txtNombre.getText().toUpperCase();
		String apellido1 = txtApellido1.getText().toUpperCase();
		String apellido2 = txtApellido2.getText().toUpperCase();
		String numero = txtNumero.getText().toUpperCase();
		String cp = txtCP.getText().toUpperCase();
		String localidad = txtLocalidad.getText().toUpperCase();

		if (!codigo.matches("\\d*") || codigo.isEmpty())
			errores += "\n-Error en DNI";
		if (!nombre.matches("[A-Z]*[\\s[A-Z]*]*") || nombre.isEmpty())
			errores += "\n-Error en nombre";
		if (!apellido1.matches("[A-Z]*[\\s[A-Z]*]*") || apellido1.isEmpty())
			errores += "\n-Error en apellido1";
		if (!apellido2.matches("[A-Z]*[\\s[A-Z]*]*") || apellido2.isEmpty())
			errores += "\n-Error en apellido2";
		if (!numero.matches("[0-9]*") || numero.isEmpty())
			errores += "\n-Error en n�mero";
		if (!cp.matches("[0-9]*") || cp.isEmpty())
			errores += "\n-Error en CP";
		if (!localidad.matches("[A-Z]*[\\s[A-Z]*]*") || localidad.isEmpty())
			errores += "\n-Error en localidad";

		if (errores.isEmpty()) {
			System.exit(0);
		} else {
			System.out.println("Errores: " + errores);
			JOptionPane.showMessageDialog(null, errores);
		}
	}// GEN-LAST:event_btnAceptarActionPerformed

	private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenu2MouseClicked
		JOptionPane.showMessageDialog(null, "¡Adios!");
		System.exit(0);
	}// GEN-LAST:event_jMenu2MouseClicked

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CompraProductosModificado.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CompraProductosModificado.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CompraProductosModificado.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CompraProductosModificado.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				CompraProductosModificado dialog = new CompraProductosModificado(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAceptar;
	private javax.swing.JButton btnAgregar;
	private javax.swing.JComboBox<String> cbArticulos;
	private javax.swing.JMenuItem cbGuardar;
	private javax.swing.JCheckBoxMenuItem cbMostrarImagenesMenu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jtProductos;
	private javax.swing.JLabel lblImagen;
	private javax.swing.JSpinner spnCantidad;
	private javax.swing.JTextField txtApellido1;
	private javax.swing.JTextField txtApellido2;
	private javax.swing.JTextField txtCP;
	private javax.swing.JTextField txtCalle;
	private javax.swing.JTextField txtCodigo;
	private javax.swing.JTextField txtLocalidad;
	private javax.swing.JTextField txtNombre;
	private javax.swing.JTextField txtNumero;
	// End of variables declaration//GEN-END:variables
}
