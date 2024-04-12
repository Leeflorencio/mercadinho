package com.br.mercado;

import com.br.mercado.domain.Alimento;
import com.br.mercado.domain.Bebida;
import com.br.mercado.service.BebidaService;

import java.util.Scanner;

public class MercadoBebida {

    private static BebidaService bebidaService;
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");


    public static void main(String[] args) {

        bebidaService = new BebidaService();

        System.out.println("Bem vindo ao sistema de cadastro de Bebidas. \n Escolha uma opção:\n");

        System.out.println(" 1 - Cadastro \n 2 - Listar todos as bebidas \n 3 - Buscar bebida por código " +
                "\n 4 - Excluir bebida \n 5 - Atualizar bebida");

        int opcao = 0;
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrarBebida();
                break;
            case 2:
                listarTodasBebidas();
                break;
            case 3:
                buscarBebidaPorCodigo();
                break;
            case 4:
                excluirBebida();
                break;
            case 5:
                //atualizarProduto();
                break;
        }
    }

    private static void cadastrarBebida() {
        try {
            System.out.println("Informe o nome da bebida: ");
            var nome = sc.next();

            System.out.println("Informe o codigo da bebida: ");
            var codigo = sc.nextLong();

            Bebida bebida = bebidaService.buscarPorCodigo(codigo);

            if (bebida != null) {
                System.out.println("A bebida com o código " + codigo + " já existe. " +
                        "Informe um novo código.");
                return;
            }

            System.out.println("Informe a descrição da bebida: ");
            var descricao = sc.next();

            System.out.println("Informe o preco de custo: ");
            var precoCusto = sc.nextDouble();

            System.out.println("Informe a quantidade em estoque: ");
            var quantidadeEstoque = sc.nextInt();

            System.out.println("Informe o tipo de embalagem: ");
            var embalagem = sc.next();

            System.out.println("A bebida é alcoolica: ");
            var alcoolica = sc.nextBoolean();

            System.out.println("Qual a marca da bebida: ");
            var marca = sc.next();

            bebidaService.cadastroBebida(new Bebida(nome, codigo, descricao, precoCusto, quantidadeEstoque, embalagem, alcoolica, marca));
            System.out.println("Bebida cadastrada com sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void listarTodasBebidas() {
        System.out.println("Lista de bebidas cadastradas: ");

        var bebidas = bebidaService.listarTodas();
        bebidas.stream().forEach(System.out::println);

    }

    private static void buscarBebidaPorCodigo() {
        System.out.println("Informe o codigo da bebida: ");
        var codigo = sc.nextLong();

        Bebida bebida = bebidaService.buscarPorCodigo(codigo);
        System.out.println(bebida);
    }

    private static void excluirBebida() {
        System.out.println("Informe o codigo da bebida que deseja excluir: ");
        var codigo = sc.nextLong();

        Bebida bebida = bebidaService.buscarPorCodigo(codigo);

        if (bebida == null) {
            System.out.println("Informe um código válido.");
        } else {
            bebidaService.excluirBebida(codigo);
            System.out.println("Bebida excluida com sucesso");
        }
    }

}
