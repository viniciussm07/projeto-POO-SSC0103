package com.projpoo;
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

	static Janela window1;
	static Janela window2;
	static Janela window3;

	public Janela(String titulo){
		
		super(titulo);
		//super.setSize(1280,720);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        super.setUndecorated(true);
	    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    
	}
	
	public void conteudoJanela1() throws IOException{
		
		//TELA 1
	    
	    JLabel label1 = new JLabel("Seja Bem-vindo");
	    JLabel label2 = new JLabel("Gostaria de assistir algo?");
	    JLabel espaco = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ");
	    JButton buttonOK = new JButton("Vamos la!");
	    JButton buttonHome = new JButton("HOME");
	    JButton buttonBack = new JButton("Sair");
	    
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
		buttonHome.setActionCommand("home");
	    buttonBack.addActionListener(this);
		buttonBack.setActionCommand("exit");
	    
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
	    
		window2.conteudoJanela2();

	    buttonOK.addActionListener(this);
		buttonOK.setActionCommand("goPage2");
		
	}
	
	public void conteudoJanela2() throws IOException {
		
		//TELA 2
		
		JButton buttonHome = new JButton("HOME");
	    JButton buttonBack = new JButton("Sair");
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
		buttonHome.setActionCommand("home");
	    buttonBack.addActionListener(this);
		buttonBack.setActionCommand("exit");
	    
	    //Scroll

		int numFilmes = 5, numFileiras = 2;
	    
		JPanel middlePanel = new JPanel();
		
		middlePanel.setLayout(new GridLayout(numFileiras, 1));
		middlePanel.setBackground(Color.GRAY);
		
		//Imagens

		JButton[][] vetorBotao = new JButton[numFileiras][numFilmes];
		JPanel[] vetorFileira = new JPanel[numFileiras];
		JScrollPane[] scrollHorizontal = new JScrollPane[numFileiras];

		for(int outroContador = 0; outroContador<numFileiras; outroContador++){

			vetorFileira[outroContador] = new JPanel();
			vetorFileira[outroContador].setLayout(new FlowLayout(5));
			vetorFileira[outroContador].setBackground(Color.GRAY);
			
			scrollHorizontal[outroContador] = new JScrollPane(vetorFileira[outroContador]);
			scrollHorizontal[outroContador].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			for(int contador=0; contador<numFilmes; contador++){

				String stringURL = "https://image.tmdb.org/t/p/original/boIgXXUhw5O3oVkhXsE6SJZkmYo.jpg";

				URL url = new URL(stringURL);
				BufferedImage buttonIcon = ImageIO.read(url);
				Image newImage = buttonIcon.getScaledInstance(340, 500, Image.SCALE_DEFAULT);
				vetorBotao[outroContador][contador] = new JButton(new ImageIcon(newImage));

				vetorFileira[outroContador].add(vetorBotao[outroContador][contador]);

				vetorBotao[outroContador][contador].addActionListener(this);
				vetorBotao[outroContador][contador].setActionCommand(stringURL);
				//System.out.println(contador);
			}

			middlePanel.add(vetorFileira[outroContador]);

			//System.out.println(outroContador);
		}
		
		JScrollPane scrollVertical = new JScrollPane(middlePanel);
		
		scrollVertical.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollVertical.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jp.add(scrollVertical);

	}

	public void conteudoJanela3(String stringURL) throws IOException {

		//TELA 3

		JButton buttonHome = new JButton("HOME");
	    JButton buttonBack = new JButton("Sair");
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
		buttonHome.setActionCommand("home");
	    buttonBack.addActionListener(this);
		buttonBack.setActionCommand("exit");

		//Painel do meio
		String stringSinopse = "";
		String stringAvaliacao = "";

		JPanel middlePanel = new JPanel();
		JLabel texto1 = new JLabel("Sinopse: " + stringSinopse + "\n");
		JLabel texto2 = new JLabel("Avaliacao: " + stringAvaliacao + "\n");
		JPanel imagemPanel = new JPanel();
		JPanel textPanel = new JPanel();
		
		middlePanel.setLayout(new GridLayout(1, 2));
		middlePanel.setBackground(Color.GRAY);

		imagemPanel.setLayout(new FlowLayout(1));
		textPanel.setLayout(new GridLayout(20, 1));

		//String stringURL = "https://image.tmdb.org/t/p/original/boIgXXUhw5O3oVkhXsE6SJZkmYo.jpg";

		URL url = new URL(stringURL);
		BufferedImage buttonIcon = ImageIO.read(url);
		Image newImage = buttonIcon.getScaledInstance(510, 750, Image.SCALE_DEFAULT);
		JButton icon1 = new JButton(new ImageIcon(newImage));

		imagemPanel.add(icon1);

		textPanel.add(texto1);
		textPanel.add(texto2);

		middlePanel.add(imagemPanel);
		middlePanel.add(textPanel);

		jp.add(middlePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ("home".equals(e.getActionCommand())) {
			
			window1.setVisible(true);

			window3.setVisible(false);
			window2.setVisible(false);

		}

		else if ("goPage2".equals(e.getActionCommand())){

			window2.setVisible(true);

			window1.setVisible(false);
			window3.setVisible(false);
		}

		else if ("exit".equals(e.getActionCommand())){

			window1.dispose();
			window2.dispose();
			window3.dispose();
		}
		
		else {

			String stringURL = e.getActionCommand();

			try{

				window3.conteudoJanela3(stringURL);

			} catch(IOException ex){

				ex.printStackTrace();
			}
			window3.setVisible(true);

			window1.setVisible(false);
			window2.setVisible(false);
		}
	}

	public static void main(String[] args) throws IOException {
		
		window1 = new Janela("Aplicativo Cinema - Janela1");
		window2 = new Janela("Aplicativo Cinema - Janela2");
		window3 = new Janela("Aplicativo Cinema - Janela3");

		window1.conteudoJanela1();
		window1.setVisible(true);

	}
}