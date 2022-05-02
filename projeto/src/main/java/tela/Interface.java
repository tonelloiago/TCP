package tela;

import leitor.LeitorDeArquivo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

public class Interface extends JFrame {

	//Componentes da interface
	private JTextArea textArea;
	private JTextField caminhoDoArquivoTextField;
	private JCheckBox checkBoxDownload;
	protected JComboBox<String> itens;
	protected JButton converterButton;
	protected JButton anexarArquivo;
	protected transient LeitorDeArquivo leitor;

	//Dimensoes da tela
	static final int LARGURA = 800;
	static final int ALTURA = 600;

	public Interface() {

		setLayout(null);
		this.leitor = new LeitorDeArquivo();

		setTextArea();
		setComboBox();
		setConverterButton();
		setAnexarArquivo();
		setCaminhoDoArquivoTextField();
		setCheckBox();

		add(this.itens);
		add(this.textArea);
		add(this.converterButton);
		add(this.anexarArquivo);
		add(this.caminhoDoArquivoTextField);
		add(this.checkBoxDownload);

		setBounds(0,0, LARGURA, ALTURA);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public String getConteudoTextArea() {
		return this.textArea.getText();
	}

	public void abrirGerenciadorDeArquivos() {

		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		var achouArquivo = fileChooser.showOpenDialog(null);

		if (achouArquivo == JFileChooser.APPROVE_OPTION) {
			this.leitor.setArquivoAnexado(fileChooser.getSelectedFile());
			this.leitor.setTemArquivo(true);
		}
	}

	private void setCheckBox() {
		this.checkBoxDownload = new JCheckBox();
		this.checkBoxDownload.setBounds(600, 200, 150, 30);
	}

	protected void setLabelCheckBox(String labelCheckBox) {
		this.checkBoxDownload.setText(labelCheckBox);
	}

	protected boolean checkBoxMarcada() {
		return checkBoxDownload.isSelected();
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

	private void setComboBox( ) {

		this.itens = new JComboBox<>();
		this.itens.setBounds(600, 150, 150, 30);

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

	protected void setTituloInterface(String titulo) {
		setTitle(titulo);
	}

	protected void getArquivoDeTexto() {
		//Abre o gerenciador para encontrar um arquivo
		this.abrirGerenciadorDeArquivos();

		if(this.leitor.getTemArquivo()) {
			atualizaCaminhoDoArquivoTextField(this.leitor.getCaminhoDoArquivo());
		}
	}

	protected void setOpcoesComboBox(String[] itens) {

		for (String item: itens) {
			this.itens.addItem(item);
		}

	}


}