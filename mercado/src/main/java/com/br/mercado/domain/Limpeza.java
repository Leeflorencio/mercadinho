package com.br.mercado.domain;

public class Limpeza extends Produto{

    private String tipoProduto;
    private String conteudoKg;
    private String instrucoesDeUso;

    public Limpeza(){}

    public Limpeza(String nome, Long codigo, String descricao, double precoCusto, int quantidadeEstoque,
                   String tipoProduto, String conteudoKg, String instrucoesDeUso) {
        super(nome, codigo, descricao, precoCusto, quantidadeEstoque);
        this.tipoProduto = tipoProduto;
        this.conteudoKg = conteudoKg;
        this.instrucoesDeUso = instrucoesDeUso;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getConteudoKg() {
        return conteudoKg;
    }

    public void setConteudoKg(String conteudoKg) {
        this.conteudoKg = conteudoKg;
    }

    public String getInstrucoesDeUso() {
        return instrucoesDeUso;
    }

    public void setInstrucoesDeUso(String instrucoesDeUso) {
        this.instrucoesDeUso = instrucoesDeUso;
    }

    public String exibirInstrucaoDeUso(){
        return "Intrução de uso do produto: \n" + instrucoesDeUso;
    }

    @Override
    public String exibirInformacoes() {
         return "Produto: " + super.getNome() + "\nCodigo: " + super.getCodigo()
                + "\nPreço de Custo: " + super.getPrecoCusto() +  "\nEstoque: " + super.getQuantidadeEstoque() +
                "\nDescrição: " + super.getDescricao()  + "\nTipo do Produto: " + tipoProduto +
                "\nConteudo (kg/ml): " + conteudoKg + "\n-----------------------------------";
    }

}
