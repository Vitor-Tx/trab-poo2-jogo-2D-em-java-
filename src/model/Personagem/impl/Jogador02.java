package model.Personagem.impl;

import model.strategy.impl.*;
import model.Personagem.Jogador;

public class Jogador02 extends Jogador {

    public Jogador02() {
        super(new PuloAlto(), new VelocidadeRapida(), new AtaqueMedio());
    }

    public Jogador02(int l, int a) {
        super(l, a, new PuloAlto(), new VelocidadeRapida(), new AtaqueMedio());
    }
}
