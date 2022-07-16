import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Janela extends JFrame implements ActionListener{

	public Janela(String titulo){
		
		super(titulo);
		super.setSize(1280,720);
	    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    
	}
	
	public void conteudoJanela1() {
		
		//TELA 1
	    
	    JLabel label1 = new JLabel("Seja Bem-vindo");
	    JLabel label2 = new JLabel("Gostaria de assistir algo?");
	    JLabel espaco = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ");
	    JButton buttonOK = new JButton("Vamos la!");
	    JButton buttonHome = new JButton("HOME");
	    JButton buttonBack = new JButton("Voltar");
	    
	    JPanel jp = (JPanel) this.getContentPane();
	    jp.setLayout(new BorderLayout(8, 6));
	    jp.setBackground(Color.GRAY);
	    
	    this.getRootPane().setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, Color.BLACK));
	    
	    //Barra de cima.
	    
	    JPanel barra = new JPanel();
	    barra.setBackground(Color.WHITE);
	    barra.setLayout(new FlowLayout(5));
	    
	    barra.add(buttonHome);
	    barra.add(espaco);
	    barra.add(buttonBack);
	    jp.add(barra, BorderLayout.NORTH);
	   
	    buttonHome.addActionListener(this);
	    buttonBack.addActionListener(this);
	    
	    //Conteudo do meio.
	    
	    JPanel meio = new JPanel();
	    JPanel meio1 = new JPanel();
	    JPanel meio2 = new JPanel();
	    JPanel meio3 = new JPanel();
	    
	    meio.setBackground(Color.GRAY);
	    meio.setLayout(new GridLayout(20, 1));
	    
	    meio1.setLayout(new FlowLayout(1));
	    meio2.setLayout(new FlowLayout(1));
	    meio3.setLayout(new FlowLayout(1));
	    
	    meio1.add(label1);
	    meio2.add(label2);
	    meio3.add(buttonOK);
	        	
	    meio.add(meio1);
	    meio.add(meio2);
	    meio.add(meio3);
	    
	    jp.add(meio, BorderLayout.CENTER);
	    
	    buttonOK.addActionListener(this);
		
	}
	
	public void conteudoJanela2() throws IOException {
		
		//TELA 2
		
		JButton buttonHome = new JButton("HOME");
	    JButton buttonBack = new JButton("Voltar");
	    JLabel espaco = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ");
			
		JPanel jp = (JPanel) this.getContentPane();
	    jp.setLayout(new BorderLayout(8, 6));
	    jp.setBackground(Color.GRAY);
	    
	    this.getRootPane().setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, Color.BLACK));
		
		//Barra de cima.
	    
	    JPanel barra = new JPanel();
	    barra.setBackground(Color.WHITE);
	    barra.setLayout(new FlowLayout(5));
	    
	    barra.add(buttonHome);
	    barra.add(espaco);
	    barra.add(buttonBack);
	    jp.add(barra, BorderLayout.NORTH);
	   
	    buttonHome.addActionListener(this);
	    buttonBack.addActionListener(this);
	    
	    //Scroll
	    
		JPanel middlePanel = new JPanel();
		
		//JLabel recomendado = new JLabel("Recomendado");
		
		middlePanel.setLayout(new GridLayout(4, 1));
		middlePanel.setBackground(Color.GRAY);
		
		JPanel fileira1 = new JPanel();
		fileira1.setLayout(new FlowLayout(5));
		fileira1.setBackground(Color.GRAY);
		
		JScrollPane scrollHorizontal1 = new JScrollPane(fileira1);
		scrollHorizontal1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//Imagens
		
		URL url = new URL("https://image.tmdb.org/t/p/original/fVzXp3NwovUlLe7fvoRynCmBPNc.jpg");
		BufferedImage buttonIcon = ImageIO.read(url);
		Image newImage = buttonIcon.getScaledInstance(340, 500, Image.SCALE_DEFAULT);
		JButton icon1 = new JButton(new ImageIcon(newImage));
		//icon1.setBorder(BorderFactory.createEmptyBorder());
		
		buttonIcon = ImageIO.read(new File("./Imagens/./1984.jpg"));
		newImage = buttonIcon.getScaledInstance(340, 500, Image.SCALE_DEFAULT);
		JButton icon2 = new JButton(new ImageIcon(newImage));
		
		buttonIcon = ImageIO.read(new File("./Imagens/./Magia.jpg"));
		newImage = buttonIcon.getScaledInstance(340, 500, Image.SCALE_DEFAULT);
		JButton icon3 = new JButton(new ImageIcon(newImage));
		
		buttonIcon = ImageIO.read(new File("./Imagens/./MegaMente.jpg"));
		newImage = buttonIcon.getScaledInstance(340, 500, Image.SCALE_DEFAULT);
		JButton icon4 = new JButton(new ImageIcon(newImage));
		
		buttonIcon = ImageIO.read(new File("./Imagens/./Livros.jpg"));
		newImage = buttonIcon.getScaledInstance(340, 500, Image.SCALE_DEFAULT);
		JButton icon5 = new JButton(new ImageIcon(newImage));
		
		buttonIcon = ImageIO.read(new File("./Imagens/./Ultimato.jpg"));
		newImage = buttonIcon.getScaledInstance(340, 500, Image.SCALE_DEFAULT);
		JButton icon6 = new JButton(new ImageIcon(newImage));
		
		fileira1.add(icon1);
		fileira1.add(icon2);
		fileira1.add(icon3);
		fileira1.add(icon4);
		fileira1.add(icon5);
		fileira1.add(icon6);
		
		//middlePanel.add(recomendado);
		middlePanel.add(scrollHorizontal1);
		
		JScrollPane scrollVertical = new JScrollPane(middlePanel);
		
		scrollVertical.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollVertical.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jp.add(scrollVertical);
		
		//jp.add(middlePanel, BorderLayout.CENTER);
		//JTextArea display = new JTextArea(16, 160);
		//display.setEditable(true); // set textArea non-editable

	}

	public static void main(String[] args) throws IOException {
		
		Janela window = new Janela("Aplicativo Cinema");
		window.conteudoJanela2();
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
