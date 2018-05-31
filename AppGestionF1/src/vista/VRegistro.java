package vista;

import javax.swing.JPanel;

import controlador.ControladorPI;
import modelo.Piloto;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VRegistro extends JPanel implements MetodosIni {
	private JTextField txtNombre;
	private JTextField txtNacionalidad;
	private JTextField txtEscuderia;
	private JButton btnGuardar;
	private JLabel lblEscudera;
	private JSpinner spnEdad;
	private JLabel lblEdad;
	private JLabel lblNacionalidad;
	private JLabel lblNombre;
	private JSpinner spnNumero;
	private JLabel lblNmero;
	private JLabel lblRegistroDePilotos;

	public VRegistro() {
		super();
		

		inicializar();
	}

	@Override
	public void inicializar() {
		
		setSize(new Dimension(380, 190));
		
		lblRegistroDePilotos = new JLabel("REGISTRO DE PILOTOS DE F1");
		
		lblNmero = new JLabel("Número:");
		
		spnNumero = new JSpinner();
		spnNumero.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		
		lblNombre = new JLabel("Nombre:");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		lblNacionalidad = new JLabel("Nacionalidad:");
		
		lblEdad = new JLabel("Edad:");
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(18, 18, 100, 1));
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		
		lblEscudera = new JLabel("Escudería:");
		
		txtEscuderia = new JTextField();
		txtEscuderia.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(lblRegistroDePilotos, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNmero, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdad))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEscuderia, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(spnNumero, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addComponent(spnEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNacionalidad)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNacionalidad)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEscudera, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(259, Short.MAX_VALUE)
					.addComponent(btnGuardar)
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegistroDePilotos, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNmero)
						.addComponent(spnNumero, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNombre)
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(spnEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNacionalidad)
						.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEscudera)
						.addComponent(txtEscuderia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnGuardar)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public Piloto getDatosPiloto() {
		int numero= (int) spnNumero.getValue();
		String nombre = txtNombre.getText();
		String nacionalidad = txtNacionalidad.getText();
		int edad = (int) spnEdad.getValue();
		String escuderia= txtEscuderia.getText();
		
		Piloto piloto = new Piloto(numero, nombre, nacionalidad, edad, escuderia);
		return piloto;
	}
	
public void mostrarResultado() {
		
		JOptionPane.showMessageDialog(getParent(), 
				"La informacion ha sido introducida correctamente",
				"Información ",
				 JOptionPane.INFORMATION_MESSAGE);
		
		limpiarDatos();
		
	}

	private void limpiarDatos() {
		spnNumero.setValue(1);
		txtNombre.setText("");
		txtNacionalidad.setText("");
		spnEdad.setValue(18);
		txtEscuderia.setText("");
		
	}
	

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	@Override
	public void setControlador(ControladorPI control) {
		btnGuardar.addActionListener(control);
	}

	
}
