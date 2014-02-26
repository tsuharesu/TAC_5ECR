package br.javacv.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Visao {


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

    // Negativa as cores ********************************************************
    public int[][][] negativoRGB(int[][][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][][] matriz = new int[largura][altura][3];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha][0] = 255 - origem[coluna][linha][0];
                matriz[coluna][linha][1] = 255 - origem[coluna][linha][1];
                matriz[coluna][linha][2] = 255 - origem[coluna][linha][2];
            }
        }
        return matriz;
    }

    // Negativa em cinza ********************************************************
    public int[][] negativoCinza(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                matriz[coluna][linha] = 255 - origem[coluna][linha];
            }
        }
        return matriz;
    }

    // Faz uma média dos valores em volta - borrao ********************************************************
    public int[][] fpbMedia3x3(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int valor = (
                        + 1 * origem[coluna - 1][linha - 1] + 1 * origem[coluna][linha - 1] + 1 * origem[coluna + 1][linha - 1]
                        + 1 * origem[coluna - 1][linha]     + 1 * origem[coluna][linha]     + 1 * origem[coluna + 1][linha]
                        + 1 * origem[coluna - 1][linha + 1] + 1 * origem[coluna][linha + 1] + 1 * origem[coluna + 1][linha + 1]
                            ) / 9;
                matriz[coluna][linha] = valor;
            }
        }
        return matriz;
    }

    // Pega a mediana dos valores em volta - borra menos ********************************************************
    public int[][] fpbMediana3x3(int[][] origem) {
        int largura = origem.length;
        int altura = origem[0].length;
        int[][] matriz = new int[largura][altura];
        for (int linha = 1; linha < altura - 1; linha++) {
            for (int coluna = 1; coluna < largura - 1; coluna++) {
                int valor[] = {
                        + 1 * origem[coluna - 1][linha - 1], + 1 * origem[coluna][linha - 1], + 1 * origem[coluna + 1][linha - 1],
                        + 1 * origem[coluna - 1][linha],     + 1 * origem[coluna][linha]    , + 1 * origem[coluna + 1][linha],
                        + 1 * origem[coluna - 1][linha + 1], + 1 * origem[coluna][linha + 1], + 1 * origem[coluna + 1][linha + 1]
                };
                Arrays.sort(valor);
                matriz[coluna][linha] = valor[4];
            }
        }
        return matriz;
    }

    public int limite0To255(int valor){
        if (valor < 0) {
            return 0;
        } else if (valor > 255) {
            return 255;
        } else {
            return valor;
        }
    }


}
