package tela;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Interface extends JFrame {

	//Componentes da interface
	public JTextArea textArea;
	private JComboBox<String> instrumentsList;
	private final String[] instruments;
	public JButton converterButton;

	//Dimensoes da tela
	final int windowWidth = 800;
	final int windowHeigth = 600;

	public Interface() {

		setLayout(null);

		this.instruments = new String[]{"Violão", "Guitarra", "Bateria", "Piano"};

		setTextArea();
		setInstrumentsComboBox();
		setConverterButton();

		add(this.instrumentsList);
		add(this.textArea);
		add(this.converterButton);

		setTitle("Gerador de Música");
		setBounds(0,0, this.windowWidth, this.windowHeigth);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setTextAreaBorder() {

		Border borderLine = BorderFactory.createLineBorder(Color.BLACK);
		Border borderEmpty= BorderFactory.createEmptyBorder(10, 10, 10, 10);

		this.textArea.setBorder(BorderFactory.createCompoundBorder(borderLine,borderEmpty));

	}

	private void setTextArea( ) {

		this.textArea = new JTextArea();
		this.setTextAreaBorder();
		//Fazer dinâmico
		this.textArea.setBounds(50,50,500,300);

	}

	private void setInstrumentsComboBox( ) {

		this.instrumentsList = new JComboBox<>(this.instruments);
		this.instrumentsList.setBounds(600, 150, 150, 30);

	}

	private void setConverterButton() {

		this.converterButton = new JButton();
		this.converterButton.setBounds(600, 70, 150, 30);
		this.converterButton.setText("Converter");

	}

}