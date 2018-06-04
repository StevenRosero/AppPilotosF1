package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import accesoBBDD.PilotosPersistencia;
import modelo.Piloto;
import vista.VConsulta;
import vista.VModificar;
import vista.VPrincipal;
import vista.VRegistro;

public class ControladorPI implements ActionListener, MouseListener{
	private VPrincipal vPpal;
	private VRegistro vRegis;
	private VConsulta vConsul;
	private VModificar vMod;
	private PilotosPersistencia pp;
	
	public ControladorPI(VPrincipal vPpal, VRegistro vRegis, VConsulta vConsul, VModificar vMod) {
		this.vPpal = vPpal;
		this.vRegis = vRegis;
		this.vConsul = vConsul;
		this.vMod = vMod;
		pp = new PilotosPersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Piloto> listaPilotosSel = new ArrayList<Piloto>();
		int[] filasSel = vConsul.getTblPilotos().getSelectedRows();
		
		Piloto piloto = null;
		
		int numero;
		String nombre="";
		String nacionalidad="";
		int edad;
		String escuderia="";
		
		for(int i =0; i<filasSel.length;i++) {
			numero = (int) vConsul.getTblPilotos().getModel().getValueAt(filasSel[i], 0);
			nombre=  (String) vConsul.getTblPilotos().getModel().getValueAt(filasSel[i], 1);
			nacionalidad =  (String) vConsul.getTblPilotos().getModel().getValueAt(filasSel[i], 2);
			edad = (int) vConsul.getTblPilotos().getModel().getValueAt(filasSel[i], 3);
			escuderia = (String) vConsul.getTblPilotos().getModel().getValueAt(filasSel[i], 4);
			piloto = new Piloto(numero, nombre, nacionalidad, edad, escuderia);
			listaPilotosSel.add(piloto);
			
		}
		
		
		String msg="";
		for(Piloto pi: listaPilotosSel) {
			msg = pp.borrarPilotoporNumero(pi.getNumero());
			JOptionPane.showMessageDialog(vConsul,"Resultado de borrar el alumno" + pi.getNombre() +
					" : " + msg +
					"resultado" +
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		vConsul.cargartabla();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int[] filasSel = vConsul.getTblPilotos().getSelectedRows();
		
		if (filasSel.length > 0) {
			vConsul.getBtnEliminar().setEnabled(true);
		}else {
			vConsul.getBtnEliminar().setEnabled(false);
		}
		
	}
	
	
	public void setvMod(VRegistro vReg) {
		this.vRegis = vRegis;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
