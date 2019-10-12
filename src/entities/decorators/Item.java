package entities.decorators;

import entities.Jogo;
import entities.auxiliars.AudioPlayer;
import entities.auxiliars.Posicao;
import entities.personagem.Personagem;
import entities.decorators.impl.Gelo;
import entities.decorators.impl.Fogo;
import entities.decorators.impl.Veneno;
import java.util.Random;

/*
Itens são responsáveis pela atribuição de Decoradores aos Ataques do Personagem.
Teremos um tipo de Item pra cada Decorador.
*/

public class Item {
    private int altura;
    private int largura;
    private Posicao posicao;
    private static final int MAX = 3; //Quantidade de Decoradores.
    private int id; //Armazena um valor >= 0 e < (MAX - 1). Cada valor representará um Decorador.
    Random random = new Random();

    public Item(){  //Construtor utilizado para a criação de um item aleatório.
            this.largura = 10;
            this.altura = 10;
            this.id = random.nextInt(MAX-1); //geração de ID aleatória
            setPosicao(new Posicao(random.nextInt(500), random.nextInt(500), this));
    }
    
    public Item(int a, int l, int i) { //Construtor utilizado para a criação de um item específico
        this.largura = l;
        this.altura = a;
        if (i >= 0 && i <= MAX-1) { //Caso o ID fornecido seja > MAX...
            this.id = i;
        } else {
            this.id = random.nextInt(MAX-1); //... um ID aleatório entre os valores permitidos é gerado.
        }
        setPosicao(new Posicao(random.nextInt(500), random.nextInt(500), this));
    }
    public void catchItem(Personagem p) {
        AudioPlayer.playSound(Jogo.itemCatchUrl);
        switch (this.id) {
            case 0: p.setAtaque(new Gelo(p.getAtaque())); break;
            case 1: p.setAtaque(new Veneno(p.getAtaque())); break;
            default: p.setAtaque(new Fogo(p.getAtaque()));
        }
    }

    public static int getMAX() {
        return MAX;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getId() {
        return id;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Posicao getPosicao() {
        return posicao;
    }
}
