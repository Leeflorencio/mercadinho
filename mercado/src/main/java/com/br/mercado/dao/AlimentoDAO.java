package com.br.mercado.dao;

import com.br.mercado.ConnectionFactory;
import com.br.mercado.domain.Alimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AlimentoDAO {

    private Connection conn;

    public AlimentoDAO(Connection connection, ConnectionFactory connectionFactory) {
        this.conn = connection;
    }


    public void cadastrar(Alimento alimento) {

        String sql = "INSERT INTO alimento (nome, codigo, descricao, preco_custo, qtd_estoque)" +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, alimento.getNome());
            preparedStatement.setLong(2, alimento.getCodigo());
            preparedStatement.setString(3, alimento.getDescricao());
            preparedStatement.setDouble(4, alimento.getPrecoCusto());
            preparedStatement.setInt(5, alimento.getQuantidadeEstoque());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Long codigo) {
        String sql = "DELETE FROM alimento WHERE codigo LIKE ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, codigo);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Alimento> listar() {

        ResultSet resultSet;
        Set<Alimento> alimentos = new HashSet<>();
        String sql = "SELECT * FROM alimento";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString(1);
                Long codigo = resultSet.getLong(2);
                String descricao = resultSet.getString(3);
                Double preco_custo = resultSet.getDouble(4);
                Integer qtd_estoque = resultSet.getInt(5);

                alimentos.add(new Alimento(nome, codigo, descricao, preco_custo, qtd_estoque));
            }
            resultSet.close();
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alimentos;
    }

    public Alimento buscarProduto(Long identificador) {
        String sql = "SELECT nome, codigo, descricao, preco_custo, qtd_estoque FROM alimento WHERE codigo = ?";

        ResultSet resultSet;
        Alimento produto = null;
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

                produto = new Alimento(nome, codigo, descricao, preco_custo, qtd_estoque);
            } else {
                System.out.println("O produto com o código " + identificador + " não foi encontrado.");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return produto;
    }

}
