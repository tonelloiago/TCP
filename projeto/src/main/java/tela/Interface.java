package tela;

import decodificadores.DecodificadorTexto;
import tocador.ControladorMusical;

import javax.swing.JOptionPane;

public class Interface {
	private final ControladorMusical controladorMusical;
	private final DecodificadorTexto decodificadorTexto;

	public Interface(final ControladorMusical controladorMusical, DecodificadorTexto decodificador) {
		this.controladorMusical = controladorMusical;
		this.decodificadorTexto = decodificador;
	}

	public void abrirTela() {
		
		String A, c;
		int x, y;

		A = JOptionPane.showInputDialog("Entre um numero: ");
		
		try {
			
			x = Integer.parseInt(A);

			final var musica = decodificadorTexto.traduzTexto(A);

			controladorMusical.executaMusica(musica);

			JOptionPane.showMessageDialog(null,x,"teste input",JOptionPane.INFORMATION_MESSAGE); 
			
		
		} catch (Exception e) {
			
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Invalid"); 
			
		}
		

	}

}
