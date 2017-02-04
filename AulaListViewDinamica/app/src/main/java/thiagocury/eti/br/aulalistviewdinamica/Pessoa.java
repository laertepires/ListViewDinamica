package thiagocury.eti.br.aulalistviewdinamica;

import java.io.Serializable;

/**
 * Created by Alunos on 15/12/2016.
 */

public class Pessoa implements Serializable{

    private String nome;
    private int idade;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome +"\n "+idade;
    }
}//fecha classe
