package com.br.mercado;

import com.br.mercado.domain.Alimento;
import com.br.mercado.domain.Bebida;
import com.br.mercado.service.AlimentoService;

import java.util.Scanner;

public class MercadoAlimento {

    private static AlimentoService alimentoService;
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");


    public static void main(String[] args) {
        alimentoService = new AlimentoService();

        System.out.println("Bem vindo ao sistema de cadastro de Alimentos. \n Escolha uma opção:\n");

        System.out.println(" 1 - Cadastro \n 2 - Listar todos os produtos \n 3 - Buscar produto por código " +
                "\n 4 - Excluir produto \n 5 - Atualizar produto");

        int opcao = 0;
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrar();
                break;
            case 2:
                listarTodos();
                break;
            case 3:
                buscarProduto();
                break;
            case 4:
                excluirProduto();
                break;
            case 5:
                //atualizarProduto();
                break;
        }
    }

    private static void cadastrar() {

        try {
            System.out.println("Informe o nome do produto: ");
            var nome = sc.next();

            System.out.println("Informe o codigo do produto: ");
            var codigo = sc.nextLong();

            Alimento alimento = alimentoService.buscarPorCodigo(codigo);

            if (alimento != null) {
                System.out.println("A bebida com o código " + codigo + " já existe. " +
                        "Informe um novo código.");
                return;
            }

            System.out.println("Informe a descrição do produto: ");
            var descricao = sc.next();

            System.out.println("Informe o preco de custo: ");
            var precoCusto = sc.nextDouble();

            System.out.println("Informe a quantidade em estoque: ");
            var quantidadeEstoque = sc.nextInt();

            alimentoService.cadastroProduto(new Alimento(nome, codigo, descricao, precoCusto, quantidadeEstoque));
            System.out.println("Produto cadastrado com sucesso");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void excluirProduto() {
        System.out.println("Informe o codigo do produto que deseja excluir: ");
        var codigo = sc.nextLong();

        Alimento alimento = alimentoService.buscarPorCodigo(codigo);

        if (alimento == null) {
            System.out.println("Informe um produto em estoque.");
        } else {
            alimentoService.excluirProduto(codigo);
            System.out.println("Produto excluido com sucesso.");
        }
    }

    private static void listarTodos() {
        System.out.println("Lista de produtos: ");

        var alimentos = alimentoService.listarTodos();
        alimentos.stream().forEach(System.out::println);

    }

    private static void buscarProduto() {
        System.out.println("Informe o codigo do produto: ");
        var codigo = sc.nextLong();

        Alimento alimento = alimentoService.buscarPorCodigo(codigo);
        System.out.println(alimento);
    }
    
}
