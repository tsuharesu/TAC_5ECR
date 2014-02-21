package br.javacv.form;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import br.javacv.form.operacoes.IExecutaOperacao;
import br.javacv.main.Visao;

public class Formulario {
	
    private JFrame f = new JFrame("Visao Computacional");
    private JPanel p = new JPanel();
    private List<JLabel> labels = new ArrayList<JLabel>();
    private IExecutaOperacao executaOperacao;
	

    private void updateLabel(int index, BufferedImage img) {
		if (img != null) {
	        JLabel lblImagem =  (index < labels.size() ? labels.get(index) : new JLabel() );
	        ImageIcon icon = new ImageIcon(img);
	        lblImagem.setIcon(icon);
	        
	        if (index >= labels.size()) {
	        	labels.add(  lblImagem );
	        	p.add( lblImagem );
	        }
		}
	}
    
	
	private void addImageToLabel(BufferedImage img) {
        JLabel lblImagem = new JLabel();
		if (img != null) {
	        ImageIcon icon = new ImageIcon(img);
	        lblImagem.setIcon(icon);
		}
		labels.add(  lblImagem );
	}

    public void exibir(IExecutaOperacao executaOperacao, int[][][] matrizOriginal) {
    	
    	if (matrizOriginal != null) {
        	for(BufferedImage imgTransformadas:executaOperacao.perform(matrizOriginal)) addImageToLabel( imgTransformadas );
        	for(JLabel lbl:labels) p.add( lbl );
    	}
    	
    	p.setLayout( new FlowLayout() );
    	
        f.setJMenuBar( getMenuBar() );
        f.setMinimumSize(new Dimension(800, 300));
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        this.executaOperacao = executaOperacao;
    }
    
    
	private JMenuBar getMenuBar() {
		JMenuBar menubar = new JMenuBar();
		
		JMenu file = new JMenu("Arquivo");
		file.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem eMenuItemAbrirImagem = new JMenuItem("Abrir Imagem");
		eMenuItemAbrirImagem.setMnemonic(KeyEvent.VK_I);
		eMenuItemAbrirImagem.setToolTipText("Abrir Imagem");
		eMenuItemAbrirImagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	JFileChooser fileChooser = new JFileChooser();
            	fileChooser.setDialogTitle("Selecione um arquivo");
            	fileChooser.setCurrentDirectory(new java.io.File("."));
            	fileChooser.setVisible(true);
            	
            	if (fileChooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
            		int[][][] matrizOriginal = new Visao().arquivoMatrizRGB( fileChooser.getSelectedFile().toString() );
            		int index = 0;
            		for(BufferedImage imgTransformadas:executaOperacao.perform(matrizOriginal)) {
            			updateLabel(index++,imgTransformadas);
            		}
            		f.pack();
            	}
            }

        });
		
		
		JMenuItem eMenuItemSair = new JMenuItem("Sair");
        eMenuItemSair.setMnemonic(KeyEvent.VK_S);
        eMenuItemSair.setToolTipText("Sair da Aplicacao");
        eMenuItemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
                
        
		file.add(eMenuItemAbrirImagem);
        file.add(eMenuItemSair);
        menubar.add(file);
        
        return menubar;
	}    
    
}
