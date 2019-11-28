package model.factory.impl;

import model.factory.FactoryJogador;
import model.observer.Jogador;
import model.observer.impl.Jogador01;
import model.observer.impl.Jogador02;
import model.observer.impl.Jogador03;

public class SimpleJogadorfactory extends FactoryJogador {


    @Override
    public Jogador criaJogador() {
        Double r = Math.random() * 2;

        Jogador j = null;

        if (r <= 0.2) {
            j = new Jogador01();
        } else if (r <= 0.4) {
            j = new Jogador02();
        } else if (r <= 0.6) {
            j = new Jogador03();
        } else if (r <= 0.8) {
            j = new Jogador01();
        } else  if (r <= 1.0) {
            j = new Jogador02();
        }

        return j;
    }
}
