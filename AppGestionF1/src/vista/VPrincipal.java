package vista;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import controlador.ControladorPI;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VPrincipal extends JFrame implements MetodosIni {
	private JMenuItem mntmRegistro;
	private JMenuItem mntmConsulta;
	private JMenuItem mntmSalir;
	private JScrollPane spnContenedor;

	
	public VPrincipal() throws HeadlessException {
		super("");
		inicializar();
	}

	@Override
	public void inicializar() {
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmRegistro = new JMenuItem("REGISTRO");
		menuBar.add(mntmRegistro);
		
		mntmConsulta = new JMenuItem("CONSULTA");
		menuBar.add(mntmConsulta);
		
		mntmSalir = new JMenuItem("SALIR");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcion = JOptionPane.showConfirmDialog(getContentPane(), "Seguro que desea salir?",
						"confirmacion de Salir",
						JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		menuBar.add(mntmSalir);
		
		
		getContentPane().setLayout(null);
		
		spnContenedor = new JScrollPane();
		spnContenedor.setBounds(10, 11, 414, 216);
		getContentPane().add(spnContenedor);
		
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// asignamos tamaño a la ventana 
		setPreferredSize(new Dimension(600, 400));  

		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               

		// Se obtienen las dimensiones en pixels de la ventana.       
		Dimension ventana = this.getPreferredSize();               

		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  
				(pantalla.height - ventana.height) / 2);

	}
	public void hacerVisible() {
		pack();
		setVisible(true);
	}

	//Controlador del panel
	public void visualizarPanel(JPanel panel) {
		spnContenedor.setViewportView(panel);
	}
	
	
	@Override
	public void setControlador(ControladorPI control) {
		spnContenedor.addMouseListener(control);

	}
}
