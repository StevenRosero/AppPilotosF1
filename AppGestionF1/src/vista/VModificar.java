package vista;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import controlador.ControladorPI;
import java.awt.Dimension;
import javax.swing.JButton;

public class VModificar extends JPanel implements MetodosIni {
	private JButton btnGuardarDatos;

	public VModificar() {
		super();
		
		inicializar();
	}

	@Override
	public void inicializar() {
		setSize(new Dimension(380, 190));
		
		btnGuardarDatos = new JButton("Guardar Datos");
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGuardarDatos)
					.addContainerGap(307, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(146, Short.MAX_VALUE)
					.addComponent(btnGuardarDatos)
					.addGap(21))
		);
		setLayout(groupLayout);
	}

	@Override
	public void setControlador(ControladorPI control) {
		btnGuardarDatos.addActionListener(control);

	}

	public JButton getBtnGuardarDatos() {
		return btnGuardarDatos;
	}
	
	

}
