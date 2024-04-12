package com.br.mercado.domain;

public class Bebida extends Produto{

    private String embalagem;
    private boolean alcoolica;
    private String marca;

    public Bebida(){}

    public Bebida(String nome, Long codigo, String descricao, double precoCusto, int quantidadeEstoque, String embalagem, boolean alcoolica, String marca) {
        super(nome, codigo, descricao, precoCusto, quantidadeEstoque);
        this.embalagem = embalagem;
        this.alcoolica = alcoolica;
        this.marca = marca;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String exibirInformacoes() {
        return "Bebida: " + super.getNome() + "\nCodigo: " + super.getCodigo()
                + "\nPreço de Custo: " + super.getPrecoCusto() +  "\nEstoque: " + super.getQuantidadeEstoque() +
                "\nDescrição: " + super.getDescricao() +
                "\nEmbalagem: " + embalagem +
                "\nAlcolica: " + alcoolica
                + "\nMarca: " + marca + "\n-----------------------------------";
    }

}
