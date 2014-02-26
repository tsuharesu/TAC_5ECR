Repositório criado para as aulas de Tópicos Avançados de Computação, 5ECR - FIAP

*IntelliJ* - só importar o projeto
*Eclipse* - criar um novo projeto apontado location para pasta do projeto

## 20140225
**1. Filtro Passa Alta**

Serve para encontrar mudanças bruscas de cores na imagem, por exemplo contornos que destoam do fundo.

Definição de filtro de subida:

- quando vem de uma cor escura (preto, 0) e chega em uma cor clara (branco, 255)

#### Horizontal
Através da multiplicação de uma matriz específica (Sobel) [[-1, -2, -1], [0, 0, 0], [1, 2, 1]], conseguimos distinguir as mudanças na horizontal.
O maior valor que a máscara pode ser é 1020 (255 * 1 + 255 * 2 + 255 * 1) e o menor é -1020. Por isso temos de utilizar o valor absoluto ao invés de simplesmente o valor.
Também temos de limitar o valor a no máximo 255.

#### Vertical
Através da multiplicação de uma matriz específica (Sobel) [[-1, 0, 1], [-2, 0, 2], [-1, 0, 1]], conseguimos distinguir as mudanças na vertical.
O maior valor que a máscara pode ser é 1020 (255 * 1 + 255 * 2 + 255 * 1) e o menor é -1020. Por isso temos de utilizar o valor absoluto ao invés de simplesmente o valor.
Também temos de limitar o valor a no máximo 255.

#### Sobel
Esse filtro se utiliza dos anteriores para detectar tanto mudanças na horizontal como na vertical, conseguindo consequentemente detectar bordas dos objetos.
Conseguimos esse efeito através da Raiz Quadrada da soma do Quadrado do fpaH e fpaV (sqrt(pow(fpaV, 2) + pow(fpaH, 2)). Precisamos também colocar um limite máximo de 255 aqui.

**2. Filtro Passa Baixa**

**Minimo e Maximo**
Igual a Mediana, mas pega o menor valor (índice 0) e o maior valor (índice 8) respectivamente.


## 20140219
**1. Filtro Passa Baixa**

Serve para "borrar" a imagem. Pegará um valor e dependendo do método (média ou mediana) criará uma nova imagem com borrões.

**Media:**

Pega todos os valores e faz a média ponderada em cima da máscara. Importante:

- dividir pelo peso total da matriz-máscara
- começar pela linha 1 e coluna 1, senão vai dar ruim (índice inexistente, etc).
- se a matriz-máscara for diferente de 3x3, começa em outra linha e coluna. em uma matriz 5x5, começaria pela linha 2, coluna 2

**Mediana:**
Pega todos os valores, ordenar do menor para o maior e pegar o valor do meio.
- Em uma matriz 3x3, o valor do meio é o 4.