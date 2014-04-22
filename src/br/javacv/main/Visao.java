package br.javacv.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Visao {

       
	// Auxiliar ****************************************************************
    public int limite0To255(int valor) {
        if (valor < 0) {
            valor = 0;
        } else if (valor > 255) {
            valor = 255;
        }
        return valor;
    }
       
    // Arquivo p/ Matriz *******************************************************
    public int[][][] arquivoMatrizRGB(String arquivo) {
        int[][][] matriz;
        try {
            BufferedImage imagem = ImageIO.read(new File(arquivo));
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            matriz = new int[largura][altura][3];
            for (int linha = 0; linha < altura; linha++) {
                for (int coluna = 0; coluna < largura; coluna++) {
                    Color pixel = new Color(imagem.getRGB(coluna, linha));
                    matriz[coluna][linha][0] = pixel.getRed();
                    matriz[coluna][linha][1] = pixel.getGreen();
                    matriz[coluna][linha][2] = pixel.getBlue();
                }
            }
        } catch (IOException ex) {
            matriz = new int[0][0][0];
            Logger.getLogger(Visao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matriz;
    }

    public int[][] arquivoMatriz(String arquivo) {
        int[][] matriz;
        try {
            BufferedImage imagem = ImageIO.read(new File(arquivo));
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            matriz = new int[largura][altura];
            for (int linha = 0; linha < altura; linha++) {
                for (int coluna = 0; coluna < largura; coluna++) {
                    Color pixel = new Color(imagem.getRGB(coluna, linha));
                    matriz[coluna][linha] = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                }
            }
        } catch (IOException ex) {
            matriz = new int[0][0];
            Logger.getLogger(Visao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matriz;
    }

    // Matriz p/ Arquivo *******************************************************
    public void matrizArquivoRGB(int[][][] origem, String arquivo) {
        int largura = origem.length;
        int altura = origem[0].length;
        BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        try {
            for (int linha = 0; linha < altura; linha++) {
                for (int coluna = 0; coluna < largura; coluna++) {
                    int r = origem[coluna][linha][0];
                    int g = origem[coluna][linha][1];
                    int b = origem[coluna][linha][2];
                    Color pixel = new Color(r, g, b);
                    imagem.setRGB(coluna, linha, pixel.getRGB());
                }
            }
            ImageIO.write(imagem, "JPEG", new File(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(Visao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void matrizArquivo(int[][] origem, String arquivo) {
        int largura = origem.length;
        int altura = origem[0].length;
        BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        try {
            for (int linha = 0; linha < altura; linha++) {
                for (int coluna = 0; coluna < largura; coluna++) {
                    int valor = origem[coluna][linha];
                    Color pixel = new Color(valor, valor, valor);
                    imagem.setRGB(coluna, linha, pixel.getRGB());
                }
            }
            ImageIO.write(imagem, "JPEG", new File(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(Visao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Matriz p/ Imagem ********************************************************
    public BufferedImage matrizToImagemRGB(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                Color pixel = new Color(r, g, b);
                imagem.setRGB(coluna, linha, pixel.getRGB());
            }
        }
        return imagem;
    }

    public BufferedImage matrizToImagem(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = origem[coluna][linha];
                Color pixel = new Color(valor, valor, valor);
                imagem.setRGB(coluna, linha, pixel.getRGB());
            }
        }
        return imagem;
    }

    // Matriz p/ Matriz ********************************************************
    public int[][][] copiarMatrizRGB(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha][0] = origem[coluna][linha][0];
                matriz[coluna][linha][1] = origem[coluna][linha][1];
                matriz[coluna][linha][2] = origem[coluna][linha][2];
            }
        }
        return matriz;
    }

    public int[][] copiarMatriz(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha] = origem[coluna][linha];
            }
        }
        return matriz;
    }

    //Tons de Cinza
    public int[][] tonsCinzaMedia(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                int cinza = (r + g + b) / 3;
                matriz[coluna][linha] = cinza;
            }
        }
        return matriz;
    }

    public int[][] tonsCinzaIntensidade(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                int cinza = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                matriz[coluna][linha] = cinza;
            }
        }
        return matriz;
    }

    // Brilho ******************************************************************
    public int[][][] brilhoRGB(int[][][] origem, int brilho) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0] + brilho;
                int g = origem[coluna][linha][1] + brilho;
                int b = origem[coluna][linha][2] + brilho;
                matriz[coluna][linha][0] = limite0To255(r);
                matriz[coluna][linha][1] = limite0To255(g);
                matriz[coluna][linha][2] = limite0To255(b);
            }
        }
        return matriz;
    }

    public int[][] brilho(int[][] origem, int brilho) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = origem[coluna][linha] + brilho;
                matriz[coluna][linha] = limite0To255(valor);
            }
        }
        return matriz;
    }

    // Contraste ***************************************************************
    public int[][][] contrasteRGB(int[][][] origem, double contraste) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = (int) (origem[coluna][linha][0] * contraste);
                int g = (int) (origem[coluna][linha][1] * contraste);
                int b = (int) (origem[coluna][linha][2] * contraste);
                matriz[coluna][linha][0] = limite0To255(r);
                matriz[coluna][linha][1] = limite0To255(g);
                matriz[coluna][linha][2] = limite0To255(b);
            }
        }
        return matriz;
    }

    public int[][] contraste(int[][] origem, double contraste) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = (int) (origem[coluna][linha] * contraste);
                matriz[coluna][linha] = limite0To255(valor);
            }
        }
        return matriz;
    }

    // Binariza ****************************************************************
    public int[][] binariza(int[][] origem, int limiar) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = origem[coluna][linha];
                if (valor >= limiar) {
                    valor = 255;
                } else {
                    valor = 0;
                }
                matriz[coluna][linha] = valor;
            }
        }
        return matriz;
    }

    // Negativo ****************************************************************
    public int[][][] negativoRGB(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                matriz[coluna][linha][0] = 255 - r;
                matriz[coluna][linha][1] = 255 - g;
                matriz[coluna][linha][2] = 255 - b;
            }
        }
        return matriz;
    }

    public int[][] negativo(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = origem[coluna][linha];
                matriz[coluna][linha] = 255 - valor;
            }
        }
        return matriz;
    }
       
    // Filtro Passa-Baixa
    public int[][] fpbMedia3x3(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int valor = (+ 1 * (origem[coluna - 1][linha - 1]) + 1 * (origem[coluna][linha - 1]) + 1 * (origem[coluna + 1][linha - 1])
                             + 1 * (origem[coluna - 1][linha])     + 1 * (origem[coluna][linha])     + 1 * (origem[coluna + 1][linha])
                             + 1 * (origem[coluna - 1][linha + 1]) + 1 * (origem[coluna][linha + 1]) + 1 * (origem[coluna + 1][linha + 1])) / 9;
                matriz[coluna][linha] = valor;
            }
        }
        return matriz;
    }

    public int[][] fpbMediana3x3(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int vetor[] = {
                    origem[coluna - 1][linha - 1],
                    origem[coluna][linha - 1],
                    origem[coluna + 1][linha - 1],
                    origem[coluna - 1][linha],
                    origem[coluna][linha],
                    origem[coluna + 1][linha],
                    origem[coluna - 1][linha + 1],
                    origem[coluna][linha + 1],
                    origem[coluna + 1][linha + 1]};
                java.util.Arrays.sort(vetor);
                matriz[coluna][linha] = vetor[4];
            }
        }
        return matriz;
    }
    
    public int[][] fpbMinimo3x3(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int vetor[] = {
                    origem[coluna - 1][linha - 1],
                    origem[coluna][linha - 1],
                    origem[coluna + 1][linha - 1],
                    origem[coluna - 1][linha],
                    origem[coluna][linha],
                    origem[coluna + 1][linha],
                    origem[coluna - 1][linha + 1],
                    origem[coluna][linha + 1],
                    origem[coluna + 1][linha + 1]};
                java.util.Arrays.sort(vetor);
                matriz[coluna][linha] = vetor[0];
            }
        }
        return matriz;
    }
    
    public int[][] fpbMaximo3x3(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int vetor[] = {
                    origem[coluna - 1][linha - 1],
                    origem[coluna][linha - 1],
                    origem[coluna + 1][linha - 1],
                    origem[coluna - 1][linha],
                    origem[coluna][linha],
                    origem[coluna + 1][linha],
                    origem[coluna - 1][linha + 1],
                    origem[coluna][linha + 1],
                    origem[coluna + 1][linha + 1]};
                java.util.Arrays.sort(vetor);
                matriz[coluna][linha] = vetor[8];
            }
        }
        return matriz;
    }

    // Filtro Passa-Alta 
    public int[][] fpaSobelHorizontal(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int valor = (- 1 * (origem[coluna - 1][linha - 1]) - 2 * (origem[coluna][linha - 1]) - 1 * (origem[coluna + 1][linha - 1])
                             + 0 * (origem[coluna - 1][linha])     + 0 * (origem[coluna][linha])     + 0 * (origem[coluna + 1][linha])
                             + 1 * (origem[coluna - 1][linha + 1]) + 2 * (origem[coluna][linha + 1]) + 1 * (origem[coluna + 1][linha + 1]));
                matriz[coluna][linha] = limite0To255(Math.abs(valor));
            }
        }
        return matriz;
    }

    public int[][] fpaSobelVertical(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int valor = (- 1 * (origem[coluna - 1][linha - 1]) + 0 * (origem[coluna][linha - 1]) + 1 * (origem[coluna + 1][linha - 1])
                             - 2 * (origem[coluna - 1][linha])     + 0 * (origem[coluna][linha])     + 2 * (origem[coluna + 1][linha])
                             - 1 * (origem[coluna - 1][linha + 1]) + 0 * (origem[coluna][linha + 1]) + 1 * (origem[coluna + 1][linha + 1]));
                matriz[coluna][linha] = limite0To255(Math.abs(valor));
            }
        }
        return matriz;
    }

    public int[][] fpaSobel(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {

                int vh = (-1 * (origem[coluna - 1][linha - 1]) - 2 * (origem[coluna][linha - 1]) - 1 * (origem[coluna + 1][linha - 1])
                        + 0 * (origem[coluna - 1][linha]) + 0 * (origem[coluna][linha]) + 0 * (origem[coluna + 1][linha])
                        + 1 * (origem[coluna - 1][linha + 1]) + 2 * (origem[coluna][linha + 1]) + 1 * (origem[coluna + 1][linha + 1]));

                int vv = (-1 * (origem[coluna - 1][linha - 1]) + 0 * (origem[coluna][linha - 1]) + 1 * (origem[coluna + 1][linha - 1])
                        - 2 * (origem[coluna - 1][linha]) + 0 * (origem[coluna][linha]) + 2 * (origem[coluna + 1][linha])
                        - 1 * (origem[coluna - 1][linha + 1]) + 0 * (origem[coluna][linha + 1]) + 1 * (origem[coluna + 1][linha + 1]));

                matriz[coluna][linha] = limite0To255((int) Math.sqrt(Math.pow(vv, 2) + Math.pow(vh, 2)));
            }
        }
        return matriz;
    }

    public int[][] fpaPrewitt(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {

                int vh = (- 1 * (origem[coluna - 1][linha - 1]) - 1 * (origem[coluna][linha - 1]) - 1 * (origem[coluna + 1][linha - 1])
                          + 0 * (origem[coluna - 1][linha]) + 0 * (origem[coluna][linha]) + 0 * (origem[coluna + 1][linha])
                          + 1 * (origem[coluna - 1][linha + 1]) + 1 * (origem[coluna][linha + 1]) + 1 * (origem[coluna + 1][linha + 1]));

                int vv = (-1 * (origem[coluna - 1][linha - 1]) + 0 * (origem[coluna][linha - 1]) + 1 * (origem[coluna + 1][linha - 1])
                        - 1 * (origem[coluna - 1][linha]) + 0 * (origem[coluna][linha]) + 1 * (origem[coluna + 1][linha])
                        - 1 * (origem[coluna - 1][linha + 1]) + 0 * (origem[coluna][linha + 1]) + 1 * (origem[coluna + 1][linha + 1]));

                matriz[coluna][linha] = limite0To255((int) Math.sqrt(Math.pow(vv, 2) + Math.pow(vh, 2)));
            }
        }
        return matriz;
    }

    //Histograma
    public int[] histograma(int[][] matriz) {
        int largura = matriz.length;
        int altura = matriz[0].length;
        int[] vetor = new int[256];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = matriz[coluna][linha];
                vetor[valor] = 1 + vetor[valor];
            }
        }
        return vetor;
    }

    public double[] histogramaNormalizado(int[][] matriz) {
        int largura = matriz.length;
        int altura = matriz[0].length;
        double[] vetor = new double[256];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = matriz[coluna][linha];
                vetor[valor] = 1 + vetor[valor];
            }
        }
        int totalPontos = largura * altura;
        for (int i = 0; i <= 255; i++) {
            vetor[i] = vetor[i] / totalPontos;
        }
        return vetor;
    }

    public int[][] histogramaEqualizar(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        //Monta Histograma
        double[] histograma = new double[256];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int valor = origem[coluna][linha];
                histograma[valor] = 1 + histograma[valor];
            }
        }
        //Normaliza Histograma
        int totalPontos = largura * altura;
        for (int i = 0; i <= 255; i++) {
            histograma[i] = histograma[i] / totalPontos;
        }
        //Funçao distribuiçao acumulativa
        for (int i = 1; i <= 255; i++) {
            histograma[i] = histograma[i] + histograma[i - 1];
        }
        //Ajusta o valor acumulado para o nivel de cinza mais próximo
        for (int i = 0; i <= 255; i++) {
            histograma[i] = histograma[i] * 255;
        }
        //Percorre a matriz equalizando os niveis de cinza
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha] = (int) histograma[origem[coluna][linha]];
            }
        }
        return matriz;
    }

    //Morfologia
    public int[][] dilatacao(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                if (origem[coluna]    [linha] == 255) {
                    matriz[coluna - 1][linha - 1] = 255;
                    matriz[coluna]    [linha - 1] = 255;
                    matriz[coluna + 1][linha - 1] = 255;
                    matriz[coluna - 1][linha]     = 255;
                    matriz[coluna]    [linha]     = 255;
                    matriz[coluna + 1][linha]     = 255;
                    matriz[coluna - 1][linha + 1] = 255;
                    matriz[coluna]    [linha + 1] = 255;
                    matriz[coluna + 1][linha + 1] = 255;
                }
            }
        }
        return matriz;
    }

    public int[][] erosao(int[][] origem) {
        int[][]matriz = negativo(origem);
        matriz = dilatacao(matriz);
        matriz = negativo(matriz);
        return matriz;
    }

    //Segmentacao
    public int[][] regioes(int[][] origem) {
        //Define matriz de regioes
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        //Inicializa o contador de regioes
        int quantidade = 0;
        //Declara e inicializa a lista de junçoes
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(quantidade);
        //Percorre a matriz imagem
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                //Verifica se o ponto da matriz imagem e 255 
                if (origem[coluna][linha] == 255) {
                    //Regra 1 -> esquerdo = 0 e superior = 0
                    if ((matriz[coluna - 1][linha] == 0) && (matriz[coluna][linha - 1] == 0)) {
                        quantidade++;
                        matriz[coluna][linha] = quantidade;
                        //Adiciona uma junçao
                        lista.add(quantidade);
                    }
                    //Regra 2 -> esquerdo <> 0 e superior = 0
                    if ((matriz[coluna - 1][linha] != 0) && (matriz[coluna][linha - 1] == 0)) {
                        matriz[coluna][linha] = matriz[coluna - 1][linha];
                    }
                    //Regra 3 -> esquerdo = 0 e superior <> 0
                    if ((matriz[coluna - 1][linha] == 0) && (matriz[coluna][linha - 1] != 0)) {
                        matriz[coluna][linha] = matriz[coluna][linha - 1];
                    }
                    //Regra 4 -> esquerdo <> 0 e superior <> 0 e esquerdo = superior
                    if ((matriz[coluna - 1][linha] != 0) && (matriz[coluna][linha - 1] != 0)
                            && (matriz[coluna - 1][linha] == matriz[coluna][linha - 1])) {
                        matriz[coluna][linha] = matriz[coluna - 1][linha];
                    }
                    //Regra 5 -> esquerdo <> 0 e superior <> 0 e esquerdo <> superior
                    if ((matriz[coluna - 1][linha] != 0) && (matriz[coluna][linha - 1] != 0)
                            && (matriz[coluna - 1][linha] != matriz[coluna][linha - 1])) {
                        matriz[coluna][linha] = matriz[coluna - 1][linha];
                        //Altera a lista de junções
                        lista.set(matriz[coluna][linha - 1], matriz[coluna - 1][linha]);
                    }
                }
            }
        }
        //Arruma lista de junções
        for (int i = 1; i < lista.size(); i++) {
            int aux = lista.get(i);
            while (aux != lista.get(aux)) {
                aux = lista.get(aux);
            }
            lista.set(i, aux);
        }
        //Arruma a matriz de regioes
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha] = lista.get(matriz[coluna][linha]);
            }
        }
        //Conta a quantidade real de regiões
        quantidade = 0;
        for (int i = 1; i < lista.size(); i++) {
            if (i == lista.get(i)) {
                quantidade++;


            }
        }
        System.out.println(quantidade);
        //Exibe a lista de junções e a quantidade real de regiões
        for (int i = 1; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
        System.out.println("Regiões = " + quantidade);
        return matriz;
    }

    //Modelo de cores
    public int[][] rgbToY(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha] = (int) ((origem[coluna][linha][0] * 0.299)
                        + (origem[coluna][linha][1] * 0.587)
                        + (origem[coluna][linha][2] * 0.114));
            }
        }
        return matriz;

    }

    public int[][] rgbToCb(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha] = 127 + (int) ((origem[coluna][linha][0] * -0.169)
                        + (origem[coluna][linha][1] * -0.331)
                        + (origem[coluna][linha][2] * 0.500));
            }
        }
        return matriz;

    }

    public int[][] rgbToCr(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha] = 127 + (int) ((origem[coluna][linha][0] * 0.500)
                        + (origem[coluna][linha][1] * -0.419)
                        + (origem[coluna][linha][2] * -0.081));
            }
        }
        return matriz;

    }

    public int[][][] rgbToYCbCr(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha][0] = (int) ((origem[coluna][linha][0] * 0.299)
                        + (origem[coluna][linha][1] * 0.587)
                        + (origem[coluna][linha][2] * 0.114));
                matriz[coluna][linha][1] = 127 + (int) ((origem[coluna][linha][0] * -0.169)
                        + (origem[coluna][linha][1] * -0.331)
                        + (origem[coluna][linha][2] * 0.500));
                matriz[coluna][linha][2] = 127 + (int) ((origem[coluna][linha][0] * 0.500)
                        + (origem[coluna][linha][1] * -0.419)
                        + (origem[coluna][linha][2] * -0.081));
            }
        }
        return matriz;

    }

    //Skin - Detec�ao de Pele

    public int[][][] skinRgb1(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                if ((r > 95) & (g > 40) & (b > 20)) {
                    matriz[coluna][linha][0] = origem[coluna][linha][0];
                    matriz[coluna][linha][1] = origem[coluna][linha][1];
                    matriz[coluna][linha][2] = origem[coluna][linha][2];
                } else {
                    matriz[coluna][linha][0] = 255;
                    matriz[coluna][linha][1] = 0;
                    matriz[coluna][linha][2] = 0;
                }
            }
        }
        return matriz;
    }

    public int[][][] skinRgb2(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                if (Math.max(r, Math.max(g, b)) - Math.min(r, Math.min(g, b)) > 15) {
                    matriz[coluna][linha][0] = origem[coluna][linha][0];
                    matriz[coluna][linha][1] = origem[coluna][linha][1];
                    matriz[coluna][linha][2] = origem[coluna][linha][2];
                } else {
                    matriz[coluna][linha][0] = 255;
                    matriz[coluna][linha][1] = 0;
                    matriz[coluna][linha][2] = 0;
                }

            }
        }
        return matriz;
    }

    public int[][][] skinRgb3(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                if ((r - g > 15) & (r > b)) {
                    matriz[coluna][linha][0] = origem[coluna][linha][0];
                    matriz[coluna][linha][1] = origem[coluna][linha][1];
                    matriz[coluna][linha][2] = origem[coluna][linha][2];
                } else {
                    matriz[coluna][linha][0] = 255;
                    matriz[coluna][linha][1] = 0;
                    matriz[coluna][linha][2] = 0;
                }

            }
        }
        return matriz;
    }

    public int[][][] skinRgb(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int r = origem[coluna][linha][0];
                int g = origem[coluna][linha][1];
                int b = origem[coluna][linha][2];
                if ((r > 95) & (g > 40) & (b > 20) &
                        (Math.max(r, Math.max(g, b)) - Math.min(r, Math.min(g, b)) > 15) &
                        (r - g > 15) & (r > b)
                        ) {
                    matriz[coluna][linha][0] = origem[coluna][linha][0];
                    matriz[coluna][linha][1] = origem[coluna][linha][1];
                    matriz[coluna][linha][2] = origem[coluna][linha][2];
                } else {
                    matriz[coluna][linha][0] = 255;
                    matriz[coluna][linha][1] = 255;
                    matriz[coluna][linha][2] = 0;
                }
            }
        }
        return matriz;
    }

    public int[][][] skinYCbCr1(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int cb = 127 + (int) ((origem[coluna][linha][0] * -0.169)
                        + (origem[coluna][linha][1] * -0.331)
                        + (origem[coluna][linha][2] * 0.500));
                if ((cb > 75) & (cb < 125)) {
                    matriz[coluna][linha][0] = origem[coluna][linha][0];
                    matriz[coluna][linha][1] = origem[coluna][linha][1];
                    matriz[coluna][linha][2] = origem[coluna][linha][2];
                } else {
                    matriz[coluna][linha][0] = 255;
                    matriz[coluna][linha][1] = 0;
                    matriz[coluna][linha][2] = 255;
                }
            }
        }
        return matriz;

    }

    public int[][][] skinYCbCr2(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int cr = 127 + (int) ((origem[coluna][linha][0] * 0.500)
                        + (origem[coluna][linha][1] * -0.419)
                        + (origem[coluna][linha][2] * -0.081));
                if ((cr > 135) & (cr < 175)) {
                    matriz[coluna][linha][0] = origem[coluna][linha][0];
                    matriz[coluna][linha][1] = origem[coluna][linha][1];
                    matriz[coluna][linha][2] = origem[coluna][linha][2];
                } else {
                    matriz[coluna][linha][0] = 255;
                    matriz[coluna][linha][1] = 0;
                    matriz[coluna][linha][2] = 255;
                }
            }
        }
        return matriz;

    }

    public int[][][] skinYCbCr(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                int cb = 127 + (int) ((origem[coluna][linha][0] * -0.169)
                        + (origem[coluna][linha][1] * -0.331)
                        + (origem[coluna][linha][2] * 0.500));
                int cr = 127 + (int) ((origem[coluna][linha][0] * 0.500)
                        + (origem[coluna][linha][1] * -0.419)
                        + (origem[coluna][linha][2] * -0.081));
                if ((cb > 75) & (cb < 125) & (cr > 135) & (cr < 175)) {
                    matriz[coluna][linha][0] = origem[coluna][linha][0];
                    matriz[coluna][linha][1] = origem[coluna][linha][1];
                    matriz[coluna][linha][2] = origem[coluna][linha][2];
                } else {
                    matriz[coluna][linha][0] = 255;
                    matriz[coluna][linha][1] = 255;
                    matriz[coluna][linha][2] = 0;
                }
            }
        }
        return matriz;

    }
}

