package com.br.mercado.domain;

public class Produto {

    private String nome;
    private Long codigo;
    private String descricao;
    private double precoCusto;
    private int quantidadeEstoque;

    public Produto(String nome, Long codigo, String descricao, double precoCusto, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String exibirInformacoes(){
        return "Produto: " + nome + "\nCodigo: " + codigo
                + "\nPreço de Custo: " + precoCusto +  "\nEstoque: " + quantidadeEstoque +
                "\nDescrição: " + descricao +
                "\n-----------------------------------";

    }

    @Override
    public String toString() {
        return exibirInformacoes();
    }
}
