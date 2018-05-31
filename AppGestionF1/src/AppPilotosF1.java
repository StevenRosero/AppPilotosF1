import java.awt.EventQueue;

import controlador.ControladorPI;
import vista.VConsulta;
import vista.VModificar;
import vista.VPrincipal;
import vista.VRegistro;

public class AppPilotosF1 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VPrincipal vPpal = new VPrincipal();
				VRegistro vRegis = new VRegistro();
				VConsulta vConsul = new VConsulta();
				VModificar vMod = new VModificar();
				
				ControladorPI control = new ControladorPI(vPpal, vRegis, vConsul, vMod);
				
				vPpal.setControlador(control);
				vRegis.setControlador(control);
				vConsul.setControlador(control);
				vMod.setControlador(control);
				
				vPpal.hacerVisible();
				
			}
		});

	}

}
