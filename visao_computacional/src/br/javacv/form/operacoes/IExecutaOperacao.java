package br.javacv.form.operacoes;

import java.awt.image.BufferedImage;
import java.util.List;

public interface IExecutaOperacao {
	
	public List<BufferedImage> perform(int[][][] imagemMatrizOriginal);

}
