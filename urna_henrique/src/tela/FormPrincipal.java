package tela;

import java.awt.EventQueue;
import modelo.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Candidato;
import modelo.ListaPartidos;
import modelo.Partido;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;
	private boolean confirmeBranco=false,confirmeNulo=false,confirmeVoto=false;
	private String txtComparacao;
	private JLabel lblTxtPartido;
	private JLabel lblTxtNome;
	private Image img;
	private int contador=0;
	private JLabel imageview;
	private Candidato candidatoConfirme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Criando um Partido
		
				Partido partido1 = new Partido();
				partido1.setNome("Konoha");
				
				
				//Criando um candidato
				
				Candidato naruto = new Candidato();
				naruto.setNome("Naruto");
				naruto.setNumero(10013);
				
				//setando uma imagem a esse candidato
				
				BufferedImage imagemCandidato = null;
				try {
				    imagemCandidato = ImageIO.read(new File("C:\\Users\\henrique\\Desktop\\urna_henrique\\src\\tela\\naruto1.PNG"));
				        
				} catch (IOException e) {
				}
				
				naruto.setImg(imagemCandidato);
				
				//Adicionando na lista do Partido1
				
				partido1.adicionarCandidato(naruto);
				
				//Criando um segundo partido
				
				Partido partido2 = new Partido();
				partido2.setNome("Akatsuki");
						
				
				//Criando um segundo candidato
				Candidato sasuke = new Candidato();
				sasuke.setNome("Sasuke");
				sasuke.setNumero(20023);
				
				//setando uma imagem a esse candidato
				
				BufferedImage imagemCandidato2 = null;
				try {
					imagemCandidato2 = ImageIO.read(new File("C:\\Users\\henrique\\Desktop\\urna_henrique\\src\\tela\\sasuke1.PNG"));
					
				} catch (IOException e) {
				}
				
				sasuke.setImg(imagemCandidato2);
				
				//Adicionando a lista do partido2
				partido2.adicionarCandidato(sasuke);
				
				//adicionando na lista de partidos
				ListaPartidos.adicionarPartidos(partido1);
				ListaPartidos.adicionarPartidos(partido2);
				
				

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(430, 10, 98, 120);
		contentPane.add(panel);
		
		JButton btnBranco = new JButton("Branco");
		btnBranco.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBranco.setContentAreaFilled(false);
		btnBranco.setOpaque(true);
		btnBranco.setBackground(Color.white);
		
		
		btnBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				if(confirmeVoto) {
					panel.remove(imageview);
					panel.repaint();
				}
				lblTxtPartido.setText(null);
				lblTxtNome.setText(null);
				textArea.setText(null);
				textArea.append("\n Seu voto será considero em BRANCO caso clique em confirmar.");
				confirmeBranco = true;
				confirmeNulo = false;
				confirmeVoto=false;
				contador=0;
				
				
				
			
				
				
			}
		});
		btnBranco.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnBranco.setBounds(368, 346, 142, 101);
		contentPane.add(btnBranco);
		
		JButton btnCorrige = new JButton("Corrige");
		btnCorrige.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCorrige.setContentAreaFilled(false);
		btnCorrige.setOpaque(true);
		btnCorrige.setBackground(Color.orange);
		btnCorrige.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCorrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				lblTxtPartido.setText(null);
				lblTxtNome.setText(null);
				contador=0;
				confirmeBranco=false;
				confirmeNulo=false;
				textArea.setText(null);
				textArea.append(" Aperte a Tecla: \n  VERDE para confirmar este voto. \n  LARANJA para reiniciar este voto.");
				if(confirmeVoto) {
					panel.remove(imageview);
					panel.repaint();
				}
				
				
				
			}
		});
		btnCorrige.setBounds(520, 346, 127, 101);
		contentPane.add(btnCorrige);
		
		JButton btnConfirmar = new JButton("Confirma");
		btnConfirmar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBackground(Color.green);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(confirmeBranco) {
					textArea.setText(null);
					textArea.append(" Aperte a Tecla: \n  VERDE para confirmar este voto. \n  LARANJA para reiniciar este voto.");	
					Candidato.votosBranco++;
					confirmeBranco = false;
					contador=0;
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					lblTxtPartido.setText(null);
					lblTxtNome.setText(null);
					
					
				}else if(confirmeNulo) {
					textArea.setText(null);
					textArea.append(" Aperte a Tecla: \n  VERDE para confirmar este voto. \n  LARANJA para reiniciar este voto.");
					confirmeNulo = false;
					Candidato.votosNulos++;
					contador=0;
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					lblTxtPartido.setText(null);
					lblTxtNome.setText(null);
					
				}else if(confirmeVoto) {
					panel.remove(imageview);
					panel.repaint();
					textArea.setText(null);
					textArea.append(" Aperte a Tecla: \n  VERDE para confirmar este voto. \n  LARANJA para reiniciar este voto.");
					confirmeVoto = false;
					contador=0;
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					lblTxtPartido.setText(null);
					lblTxtNome.setText(null);
					candidatoConfirme.setVotos(1);
					
				}
				else if(		textField.getText().equals("9") & 
						textField_1.getText().equals("6") & 
						textField_2.getText().equals("4") & 
						textField_3.getText().equals("8") &
						textField_4.getText().equals("2")) {
						contentPane.removeAll();
						Resultado();
						revalidate();
						repaint();
					
				}
				
			}
		});
		btnConfirmar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnConfirmar.setBounds(657, 346, 119, 101);
		contentPane.add(btnConfirmar);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNumero.setBounds(54, 105, 108, 13);
		contentPane.add(lblNumero);
		
		JLabel lblPartido = new JLabel("Partido");
		lblPartido.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblPartido.setBounds(54, 167, 78, 13);
		contentPane.add(lblPartido);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNome.setBounds(54, 218, 78, 13);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBackground(Color.white);
		textField.setBounds(184, 97, 48, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.white);
		textField_1.setBounds(230, 97, 48, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBackground(Color.white);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(277, 97, 48, 33);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBackground(Color.white);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(323, 97, 48, 33);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBackground(Color.white);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(370, 97, 48, 33);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "8";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "8";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "8";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "8";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "8";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
					busca :for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);
								repaint();
								confirmeNulo = false;
								confirmeVoto=true;
								confirmeBranco = false;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton.setBounds(633, 218, 85, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "7";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "7";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "7";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "7";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "7";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca :for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);
								repaint();
								confirmeNulo = false;
								confirmeVoto=true;
								confirmeBranco = false;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_1.setBounds(538, 218, 85, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "5";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "5";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "5";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "5";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "5";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca:	for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);
								repaint();
								confirmeNulo = false;
								confirmeVoto = true;
								confirmeBranco = false;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_2.setBounds(633, 147, 85, 56);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("6");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "6";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "6";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "6";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "6";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "6";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca :for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);
								repaint();
								confirmeNulo = false;
								confirmeVoto = true;
								confirmeBranco = false;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_3.setBounds(728, 147, 85, 56);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "2";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "2";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "2";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "2";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "2";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca:	for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);		
								repaint();
								confirmeBranco = false;
								confirmeNulo = false;
								confirmeVoto=true;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_4.setBounds(633, 85, 85, 56);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("3");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "3";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "3";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "3";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "3";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "3";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca:	for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);
								repaint();
								confirmeBranco = false;
								confirmeNulo = false;
								confirmeVoto=true;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_5.setBounds(729, 85, 85, 56);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("9");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "9";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "9";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "9";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "9";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "9";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca:	for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);
								repaint();
								confirmeNulo = false;
								confirmeVoto=true;
								confirmeBranco = false;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_6.setBounds(728, 218, 85, 56);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("1");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "1";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "1";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "1";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "1";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "1";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca:	for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);		
								repaint();
								confirmeBranco = false;
								confirmeNulo = false;
								confirmeVoto=true;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_7.setBounds(538, 85, 85, 56);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("4");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "4";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "4";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "4";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "4";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "4";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca:	for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);		
								repaint();
								confirmeBranco = false;
								confirmeNulo = false;
								confirmeVoto=true;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
			}
		});
		btnNewButton_8.setBounds(538, 147, 85, 56);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("0");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String enterNumber = textField.getText() + "0";
					textField.setText(enterNumber);
				}else if(textField_1.getText().equals("")) {
					String enterNumber = textField_1.getText() + "0";
					textField_1.setText(enterNumber);
				}else if(textField_2.getText().equals("")) {
					String enterNumber = textField_2.getText() + "0";
					textField_2.setText(enterNumber);
					
				}else if(textField_3.getText().equals("")) {
					String enterNumber = textField_3.getText() + "0";
					textField_3.setText(enterNumber);
					
				}else if(textField_4.getText().equals("")) {
					String enterNumber = textField_4.getText() + "0";
					textField_4.setText(enterNumber);
					
				}
				contador++;
				if(contador == 5) {
					txtComparacao = textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText();
				busca :for(int i=0;i<ListaPartidos.partidos.size();i++) {
						for(int j=0;j<ListaPartidos.partidos.get(i).getCandidatos().size();j++) {
							if(txtComparacao.equals(Integer.toString(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNumero()))) {
								lblTxtNome.setText(ListaPartidos.partidos.get(i).getCandidatos().get(j).getNome());
								lblTxtPartido.setText(ListaPartidos.partidos.get(i).getNome());								
								Image img = ListaPartidos.partidos.get(i).getCandidatos().get(j).getImg();								
								imageview = new JLabel(new ImageIcon(img));							
								panel.add(imageview);
								repaint();
								confirmeNulo = false;
								confirmeVoto=true;
								confirmeBranco = false;
								candidatoConfirme = ListaPartidos.partidos.get(i).getCandidatos().get(j);
								break busca;
							}else if(txtComparacao.equals("96482")) {
								confirmeNulo = false;
							}else {
								confirmeNulo = true;
								confirmeBranco = false;
								confirmeVoto = false;
							}
						}
						
					}
					
					if(confirmeNulo) {
						textArea.setText(null);
						textArea.append("\n Seu voto será considero NULO caso clique em confirmar.");
					}
				}
				
			}
		});
		btnNewButton_9.setBounds(633, 284, 85, 52);
		contentPane.add(btnNewButton_9);
		
		lblTxtPartido = new JLabel("");
		lblTxtPartido.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtPartido.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblTxtPartido.setBounds(184, 169, 78, 13);
		contentPane.add(lblTxtPartido);
		
		lblTxtNome = new JLabel("");
		lblTxtNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtNome.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblTxtNome.setBounds(184, 218, 78, 13);
		contentPane.add(lblTxtNome);
		
		textArea = new JTextArea();
		textArea.setBounds(54, 250, 412, 86);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.append(" Aperte a Tecla: \n  VERDE para confirmar este voto. \n  LARANJA para reiniciar este voto.");
		contentPane.add(textArea);
		
	}
	
	public void Resultado() {
		JPanel panelResultados = new JPanel();
		panelResultados.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResultados.setBackground(new Color(255, 255, 255));
		panelResultados.setBounds(41, 24, 478, 307);
		JLabel lblResultados0 = new JLabel("Resultados");
		lblResultados0.setFont(new Font("Arial", Font.BOLD, 14));
		lblResultados0.setBounds (174, 21, 98, 14);
		JLabel lblvotosBrancos = new JLabel("Votos Brancos");
		lblvotosBrancos.setBounds(35, 51, 128, 25);
		JLabel lblvotosNulos= new JLabel("Votos Nulos");
		lblvotosNulos.setBounds (35, 67, 98, 31);
		JLabel lblresultadoVotosBrancos = new JLabel("");
		lblresultadoVotosBrancos.setBounds(124, 57, 46, 14);
		lblresultadoVotosBrancos.setText(Integer.toString(Candidato.votosBranco));
		JLabel lblresultadoVotosNulos = new JLabel("");
		lblresultadoVotosNulos.setBounds(124, 75, 46, 14);
		lblresultadoVotosNulos.setText(Integer.toString(Candidato.votosNulos));
		JLabel lblResultados1 = new JLabel("");
		lblResultados1.setBounds (124, 87, 79, 33);
		lblResultados1.setText(Integer.toString(ListaPartidos.partidos.get(0).getCandidatos().get(0).getVotos()));
		JLabel lblResultadosPartido1 = new JLabel("Naruto " +ListaPartidos.partidos.get(0).getNome());
		lblResultadosPartido1.setBounds(35, 87, 100, 33);
		JLabel lblResultadosPartido2 = new JLabel("Sasuke " +ListaPartidos.partidos.get(1).getNome());
		lblResultadosPartido2.setBounds(26, 110, 100, 33);
		JLabel lblResultados2 = new JLabel("");
		lblResultados2.setBounds (124, 111, 79, 33);
		lblResultados2.setText(Integer.toString(ListaPartidos.partidos.get(1).getCandidatos().get(0).getVotos()));
		panelResultados.add(lblResultados0);
		panelResultados.add(lblvotosBrancos);
		panelResultados.add(lblvotosNulos);
		panelResultados.add(lblresultadoVotosBrancos);
		panelResultados.add(lblresultadoVotosNulos);
		panelResultados.add(lblResultados1);
		panelResultados.add(lblResultadosPartido1);
		panelResultados.add(lblResultados2);
		panelResultados.add(lblResultadosPartido2);
		panelResultados.setLayout(null);
		contentPane.add(panelResultados);
	}
}
