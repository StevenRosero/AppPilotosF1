package vista;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import controlador.ControladorPI;
import modelo.Piloto;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import accesoBBDD.PilotosPersistencia;

import javax.swing.JButton;
import javax.swing.JTable;

public class VConsulta extends JPanel implements MetodosIni {
	private JScrollPane spTabla;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblPilotos;
	private DefaultTableModel dtm;

	public VConsulta() {
		super();
		
		
		inicializar();
	}

	@Override
	public void inicializar() {
		setSize(new Dimension(380, 190));
		
		JLabel lblListaDePilotos = new JLabel("LISTA DE PILOTOS ACTUAL");
		
		spTabla = new JScrollPane();
		spTabla.setBounds(29, 52, 374, 141);
		

		
		btnModificar = new JButton("Modificar");
		
		btnEliminar = new JButton("Eliminar");
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(lblListaDePilotos))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(spTabla, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnModificar)
							.addGap(34)
							.addComponent(btnEliminar)
							.addGap(96)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblListaDePilotos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spTabla, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar)
						.addComponent(btnEliminar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tblPilotos = new JTable();
		cargartabla();
		spTabla.setViewportView(tblPilotos);
		
		setLayout(groupLayout);

	}

	public void cargartabla() {
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {//para que sea editable hay que ponerlo en true
				if (column == 1) {
					return true;
				}else {
					return false;
				}
			}
		};
			
		tblPilotos.setModel(dtm);
		
		dtm.addColumn("Numero");
		dtm.addColumn("Nombre");
		dtm.addColumn("Nacionalidad");
		dtm.addColumn("Edad");
		dtm.addColumn("Escuderia");
		
		tblPilotos.getColumn("Numero").setPreferredWidth(15);
		tblPilotos.getColumn("NOMBRE").setPreferredWidth(15);
		tblPilotos.getColumn("Nacionalidad").setPreferredWidth(15);
		tblPilotos.getColumn("Edad").setPreferredWidth(15);
		tblPilotos.getColumn("Escuderia").setPreferredWidth(15);
		
		PilotosPersistencia ap =new PilotosPersistencia();
		ArrayList<Piloto> listaPilotos = ap.consultaPilotos();//ya hemos recuperado la lista de alumnos, haciendo lo del toDO de abajo
		Object[] fila = new Object[5];
		
		for(Piloto piloto: listaPilotos) {
			fila[0] = piloto.getNumero();
			fila[1] = piloto.getNombre();
			fila[2] = piloto.getNacionalidad();
			fila[3] = piloto.getEdad();
			fila[3] = piloto.getEscuderia();
			
			dtm.addRow(fila);//Esto aqui para que siga mostrando mas contenido
		}	
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	@Override
	public void setControlador(ControladorPI control) {
		tblPilotos.addMouseListener(control);
		btnEliminar.addActionListener(control);
		btnModificar.addActionListener(control);

	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTable getTblPilotos() {
		return tblPilotos;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	
	
	
}
