package hortas;

import java.util.ArrayList;
import java.util.List;

public class Talhao {
    private int id;
    private double area; 
    private List<Plantacao> plantacoes;

    public Talhao(int id, double area) {
        this.id = id;
        this.area = area;
        this.plantacoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public List<Plantacao> getPlantacoes() {
        return plantacoes;
    }

    public void adicionarPlantacao(Plantacao p) {
        plantacoes.add(p);
    }

    @Override
    public String toString() {
        return "Talhao{" +
                "id=" + id +
                ", area=" + area +
                ", plantacoes=" + plantacoes.size() +
                '}';
    }
}
