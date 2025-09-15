package hortas;

import java.util.ArrayList;
import java.util.List;

public class Horta {
    private String nome;
    private String localizacao;
    private List<Talhao> talhoes;

    public Horta(String nome, String localizacao) {
       this.nome = nome;
        this.localizacao = localizacao;
        this.talhoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public List<Talhao> getTalhoes() {
        return talhoes;
    }

    public void adicionarTalhao(Talhao t) {
        talhoes.add(t);
    }

    public double areaTotal() {
        double total = 0.0;
        for (Talhao t : talhoes) {
            total += t.getArea();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Horta{" +
                "nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", talhoes=" + talhoes.size() +
                '}';
    }
}

