package com.br.mercado.dao;

import com.br.mercado.domain.Alimento;
import com.br.mercado.domain.Bebida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class BebidaDAO {

    private Connection conn;

    public BebidaDAO (Connection connection){
        this.conn = connection;
    }

    public void cadastrarBebida(Bebida bebida) {

        String sql = "INSERT INTO bebidas (nome, codigo, descricao, preco_custo, qtd_estoque, " +
                "embalagem, alcoolica, marca)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, bebida.getNome());
            preparedStatement.setLong(2, bebida.getCodigo());
            preparedStatement.setString(3, bebida.getDescricao());
            preparedStatement.setDouble(4, bebida.getPrecoCusto());
            preparedStatement.setInt(5, bebida.getQuantidadeEstoque());
            preparedStatement.setString(6, bebida.getEmbalagem());
            preparedStatement.setBoolean(7, bebida.isAlcoolica());
            preparedStatement.setString(8, bebida.getMarca());

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    public void excluir(Long codigo) {

        String sql = "DELETE FROM bebidas WHERE codigo LIKE ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, codigo);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Bebida> listar() {

        ResultSet resultSet;
        Set<Bebida> bebidas = new HashSet<>();
        String sql = "SELECT * FROM bebidas";

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String nome = resultSet.getString(1);
                Long codigo = resultSet.getLong(2);
                String descricao = resultSet.getString(3);
                Double preco_custo = resultSet.getDouble(4);
                Integer qtd_estoque = resultSet.getInt(5);
                String embalagem = resultSet.getString(6);
                Boolean alcoolica = resultSet.getBoolean(7);
                String marca = resultSet.getString(8);

                bebidas.add(new Bebida(nome, codigo, descricao,preco_custo,qtd_estoque,embalagem,alcoolica,marca));
            }
            resultSet.close();
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw  new RuntimeException();
        }
        return bebidas;
    }

    public Bebida buscarBebida(Long identificador) {
        String sql = "SELECT nome, codigo, descricao, preco_custo, qtd_estoque, embalagem," +
                "alcoolica, marca FROM bebidas WHERE codigo = ?";

        ResultSet resultSet;
        Bebida bebida = null;
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
                String embalagem = resultSet.getString(6);
                Boolean alcoolica = resultSet.getBoolean(7);
                String marca = resultSet.getNString(8);

                bebida = new Bebida(nome, codigo, descricao, preco_custo, qtd_estoque, embalagem, alcoolica, marca);
            } else{
                System.out.println("A bebida com o código " + identificador + " não foi encontrada.");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bebida;
    }
}
