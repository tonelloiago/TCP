package tela;

import leitor.LeitorDeArquivo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Interface extends JFrame {

	//Componentes da interface
	public JTextArea textArea;
	private JTextField caminhoDoArquivoTextField;
	protected JComboBox<String> instrumentsList;
	protected final String[] instruments;
	public JButton converterButton;
	public JButton anexarArquivo;
	protected LeitorDeArquivo leitor;

	//Dimensoes da tela
	final int windowWidth = 800;
	final int windowHeigth = 600;

	public Interface() {

		setLayout(null);
		this.instruments = new String[]{"Violão", "Guitarra", "Bateria", "Piano"};
		this.leitor = new LeitorDeArquivo();

		setTextArea();
		setInstrumentsComboBox();
		setConverterButton();
		setAnexarArquivo();
		setCaminhoDoArquivoTextField();

		add(this.instrumentsList);
		add(this.textArea);
		add(this.converterButton);
		add(this.anexarArquivo);
		add(this.caminhoDoArquivoTextField);

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
		this.textArea.setBounds(50,50,500,300);

	}

	private void setCaminhoDoArquivoTextField() {

		this.caminhoDoArquivoTextField = new JTextField();
		this.caminhoDoArquivoTextField.setBounds(50, 400, 300, 30);
		this.caminhoDoArquivoTextField.setEditable(false);
		this.caminhoDoArquivoTextField.setText("C:\\");

	}

	private void atualizaCaminhoDoArquivoTextField(String path) {
		this.caminhoDoArquivoTextField.setText(path);
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

	private void setAnexarArquivo() {
		this.anexarArquivo = new JButton();
		this.anexarArquivo.setBounds(400, 400, 150, 30);
		this.anexarArquivo.setText("Escolher Arquivo");
	}

	protected void anexarArquivo() {
		//Abre o gerenciador para encontrar um arquivo
		this.leitor.abrirFileSystemView();

		if(this.leitor.getTemArquivo()) {
			atualizaCaminhoDoArquivoTextField(this.leitor.getCaminhoDoArquivo());
		}
	}


}