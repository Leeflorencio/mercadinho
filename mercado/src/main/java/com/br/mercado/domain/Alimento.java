package com.br.mercado.domain;

public class Alimento extends Produto {
    public Alimento() {
    }

    public Alimento(String nome, Long codigo, String descricao, double precoCusto, int quantidadeEstoque) {
        super(nome, codigo, descricao, precoCusto, quantidadeEstoque);
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes();
    }

}
