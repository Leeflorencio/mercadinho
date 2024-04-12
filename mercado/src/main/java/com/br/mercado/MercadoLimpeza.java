package com.br.mercado;

import com.br.mercado.domain.Limpeza;
import com.br.mercado.service.LimpezaService;

import java.util.Scanner;

public class MercadoLimpeza {

    private static LimpezaService limpezaService;
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        limpezaService = new LimpezaService();

        System.out.println("Bem vindo ao sistema de cadastro de produto de Limpeza. \n Escolha uma opção:\n");

        System.out.println(" 1 - Cadastro \n 2 - Listar todos os produtos \n 3 - Buscar produto por código " +
                "\n 4 - Excluir produto \n 5 - Atualizar produto");

        int opcao = 0;
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastroProdutoLimpeza();
                break;
            case 2:
                listarProdutosLimpeza();
                break;
            case 3:
                buscarProdutoLimpeza();
                break;
            case 4:
                excluirProdutoLimpeza();
                break;
            case 5:
                //atualizarProduto();
                break;
        }
    }

    public static void cadastroProdutoLimpeza() {

        try {
            System.out.println("Informe o nome do produto: ");
            var nome = sc.next();

            System.out.println("Informe o codigo do produto: ");
            var codigo = sc.nextLong();

            Limpeza limpeza = limpezaService.buscarPorCodigo(codigo);

            if (limpeza != null) {
                System.out.println("O produto de limpeza com o código " + codigo + " já existe. " +
                        "Informe um novo código.");
                return;
            }

            System.out.println("Informe a descrição do produto: ");
            var descricao = sc.next();

            System.out.println("Informe o preco de custo: ");
            var precoCusto = sc.nextDouble();

            System.out.println("Informe a quantidade em estoque: ");
            var quantidadeEstoque = sc.nextInt();

            System.out.println("Informe o tipo de produto de limpeza: ");
            var tipoProduto = sc.next();

            System.out.println("Informe o conteúdo (kg, ml)");
            var conteudoKg = sc.next();

            System.out.println("Informe as instruções de uso: ");
            var instrucoesDeUso = sc.next();

            limpezaService.cadastroProdutoLimpeza(new Limpeza(nome, codigo, descricao, precoCusto,
                    quantidadeEstoque, tipoProduto, conteudoKg, instrucoesDeUso));
            System.out.println("Produto de limpeza cadastrado com sucesso");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void excluirProdutoLimpeza() {
        System.out.println("Informe o codigo do produto que deseja excluir: ");
        var codigo = sc.nextLong();

        Limpeza limpeza = limpezaService.buscarPorCodigo(codigo);

        if (limpeza == null) {
            System.out.println("Informe um código válido.");
        } else {
            limpezaService.excluirProdutoLimpeza(codigo);
            System.out.println("Produto excluido com sucesso");
        }

    }

    private static void listarProdutosLimpeza() {
        System.out.println("Lista de produtos de limpeza cadastrados: ");

        var produtoLimpeza = limpezaService.listarProdutosLimpeza();
        produtoLimpeza.stream().forEach(System.out::println);

    }

    private static void buscarProdutoLimpeza() {
        System.out.println("Informe o codigo do produto de limpeza: ");
        var codigo = sc.nextLong();

        Limpeza produtoLimpeza = limpezaService.buscarPorCodigo(codigo);
        System.out.println(produtoLimpeza);
    }

}
