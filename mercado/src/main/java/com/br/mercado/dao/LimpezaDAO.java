package com.br.mercado.dao;

import com.br.mercado.domain.Limpeza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class LimpezaDAO {

    private Connection conn;

    public LimpezaDAO(Connection connection) {
        this.conn = connection;
    }

    public void cadastrarProdutoLimpeza(Limpeza limpeza) {

        String sql = "INSERT INTO limpeza (nome, codigo, descricao, preco_custo, qtd_estoque, " +
                "tipo_produto, conteudoKg, intrucoes_de_uso)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, limpeza.getNome());
            preparedStatement.setLong(2, limpeza.getCodigo());
            preparedStatement.setString(3, limpeza.getDescricao());
            preparedStatement.setDouble(4, limpeza.getPrecoCusto());
            preparedStatement.setInt(5, limpeza.getQuantidadeEstoque());
            preparedStatement.setString(6, limpeza.getTipoProduto());
            preparedStatement.setString(7, limpeza.getConteudoKg());
            preparedStatement.setString(8, limpeza.getInstrucoesDeUso());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Long codigo) {

        String sql = "DELETE FROM limpeza WHERE codigo LIKE ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, codigo);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Set<Limpeza> listar() {

        ResultSet resultSet;
        Set<Limpeza> produtoLimpeza = new HashSet<>();
        String sql = "SELECT * FROM limpeza";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString(1);
                Long codigo = resultSet.getLong(2);
                String descricao = resultSet.getString(3);
                Double preco_custo = resultSet.getDouble(4);
                Integer qtd_estoque = resultSet.getInt(5);
                String tipo_produto = resultSet.getString(6);
                String conteudoKg = resultSet.getString(7);
                String intrucoes_de_uso = resultSet.getString(8);

                produtoLimpeza.add(new Limpeza(nome, codigo, descricao, preco_custo, qtd_estoque,
                        tipo_produto, conteudoKg, intrucoes_de_uso));
            }
            resultSet.close();
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return produtoLimpeza;
    }

    public Limpeza buscarProdutoLimpeza(Long identificador) {

        String sql = "SELECT nome, codigo, descricao, preco_custo, qtd_estoque, tipo_produto," +
                "conteudoKg, intrucoes_de_uso FROM limpeza WHERE codigo = ?";

        ResultSet resultSet;
        Limpeza limpeza = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, identificador);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString(1);
                Long codigo = resultSet.getLong(2);
                String descricao = resultSet.getString(3);
                Double preco_custo = resultSet.getDouble(4);
                Integer qtd_estoque = resultSet.getInt(5);
                String tipo_produto = resultSet.getString(6);
                String conteudoKg = resultSet.getString(7);
                String intrucoes_de_uso = resultSet.getNString(8);

                limpeza = new Limpeza(nome, codigo, descricao, preco_custo, qtd_estoque,
                        tipo_produto, conteudoKg, intrucoes_de_uso);
            } else {
                System.out.println("O produto com o código " + identificador + " não foi encontrado.");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return limpeza;
    }
}
