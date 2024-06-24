
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;

public class Produtos extends ItemCarrinho {

    private String nomePerfume;
    private String genero;
    private String designer;
    private String acordes;
    private double volume;
    private String fragrancia;
    private String tipo;
    private float preco;
    private int codperfume;
    private String caminhoImagem;
    private String descricao; // Novo atributo para a descrição do perfume
    private int quantidade; // Campo para a quantidade

    public Produtos () {
        super();

        // Aqui você pode inicializar os valores padrão, se necessário
        this.nomePerfume = "Sem nome";
        this.genero = "Sem gênero";
        this.designer = "Sem designer";
        this.acordes = "Sem acordes";
        this.volume = 0.0;
        this.fragrancia = "Sem fragrância";
        this.tipo = "Sem tipo";
        this.preco = 0.0f;
        this.codperfume = 0;
        this.caminhoImagem = ""; // Inicializa o caminho da imagem vazio por padrão
        this.descricao = "Sem descrição";
        this.quantidade = 0; // Inicializa a quantidade como zero
    }
    public Produtos(String nomePerfume, String genero, String designer, String acordes, double volume, String fragrancia, String tipo, float preco,
                    int codperfume, String caminhoImagem, String descricao, int quantidade) {
        this();
        this.nomePerfume = nomePerfume;
        this.genero = genero;
        this.designer = designer;
        this.acordes = acordes;
        this.volume = volume;
        this.fragrancia = fragrancia;
        this.tipo = tipo;
        this.preco = preco;
        this.codperfume = codperfume;
        this.caminhoImagem = caminhoImagem;// Define o caminho da imagem
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public static ArrayList<Produtos> createProdutos() {
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();

        // Adicionando produtos à lista
        produtos.add(new Produtos("Miss Dior", "Feminino", "Dior", "Amadeirado, Cítrico", 50.0,
                "Sem fragrância específica", "Eau de Toilette", 500.f, 01,"Miss Dior1.png",
                "Miss Dior é uma fragrância  envolvente, ideal para mulheres modernas e sofisticadas.",20));
        produtos.add(new Produtos("Chanel Nº 5", "Feminino", "Chanel", "Floral", 100.0,
                "Jasmim, Baunilha", "Eau de Parfum", 750.f, 02,"/Chanel 5.jpg",
                "Chanel Nº 5 é um ícone da perfumaria mundial, conhecido por sua elegância atemporal.",30));
        produtos.add(new Produtos("Acqua di Giò", "Masculino", "Giorgio Armani", "Aquático", 70.0, "Laranja, Limão", "Eau de Toilette", 400.f, 03,"Acqua di Gio.jpg",
                "Acqua di Giò é uma fragrância refrescante e energizante, perfeita para o homem contemporâneo.",40));
        produtos.add(new Produtos("Dolce & Gabbana Light Blue", "Feminino", "Dolce & Gabbana", "Floral Frutado", 90.0, "Maçã, Cedro", "Eau de Toilette", 600.f, 04,"Dolce Gabbana.jpg",
                "Light Blue captura a essência do verão italiano, com notas frescas e cítricas.",50));
        produtos.add(new Produtos("Azzaro Pour Homme", "Masculino", "Azzaro", "Amadeirado", 60.0, "Lavanda, Âmbar", "Eau de Toilette", 450.f, 05,"Azzaro.jpg",
                "Light Blue captura a essência do verão italiano, com notas frescas e cítricas.",30));
        produtos.add(new Produtos("212 Vip", "Feminino", "Carolina Herrera", "Amadeirado", 50.0, "Âmbar Floral", "Eau de Parfum", 400.f, 06,"212VIP.png",
                "Ícone moderno de juventude, o perfume 212 VIP vem em um frasco dourado matte, de design metálico e arredondado.",40));

        return produtos;
    }

    public String getNomePerfume() {
        return nomePerfume;
    }

    public void setNomePerfume(String nomePerfume) {
        this.nomePerfume = nomePerfume;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getAcordes() {
        return acordes;
    }

    public void setAcordes(String acordes) {
        this.acordes = acordes;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getFragrancia() {
        return fragrancia;
    }

    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getCodperfume() {
        return codperfume;
    }

    public void setCodperfume(int codperfume) {
        this.codperfume = codperfume;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return "Nome do perfume: " + nomePerfume + "\n" +
                "Gênero: " + genero + "\n" +
                "Designer: " + designer + "\n" +
                "Acordes: " + acordes + "\n" +
                "Volume: " + volume + " mL\n" +
                "Fragrância: " + fragrancia + "\n" +
                "Tipo: " + tipo + "\n" +
                "Preço: R$" + preco + "\n" +
                "Código do perfume: " + codperfume + "\n"+
                "Descrição: " + descricao + "\n" +
                "Quantidade disponível: " + quantidade;
    }
}


