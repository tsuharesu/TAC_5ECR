package br.javacv.form.operacoes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import br.javacv.main.Visao;

public class Aula1 implements IExecutaOperacao {

	private Visao visao = new Visao();


	public List<BufferedImage> perform(int[][][] imagemMatrizOriginal) {
		List<BufferedImage> images = new ArrayList<BufferedImage>();


                images.add(  visao.matrizToImagemRGB( imagemMatrizOriginal )  );




		return images;
	}

}
