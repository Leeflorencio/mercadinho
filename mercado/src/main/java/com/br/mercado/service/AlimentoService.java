package com.br.mercado.service;

import com.br.mercado.ConnectionFactory;
import com.br.mercado.dao.AlimentoDAO;
import com.br.mercado.domain.Alimento;

import java.sql.Connection;
import java.util.Set;

public class AlimentoService {

    private ConnectionFactory connectionFactory;

    public AlimentoService() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastroProduto(Alimento alimento) {
        Connection conn = connectionFactory.recuperarConexao();
        new AlimentoDAO(conn, connectionFactory).cadastrar(alimento);
    }

    public void excluirProduto(Long codigo) {
        Connection conn = connectionFactory.recuperarConexao();
        new AlimentoDAO(conn, connectionFactory).excluir(codigo);
    }

    public Set<Alimento> listarTodos() {
        Connection conn = connectionFactory.recuperarConexao();
        return new AlimentoDAO(conn, connectionFactory).listar();
    }

    public Alimento buscarPorCodigo(Long identificador) {
        Connection conn = connectionFactory.recuperarConexao();
        return new AlimentoDAO(conn, connectionFactory).buscarProduto(identificador);
    }

   /* public Alimento atualizarProduto(Long codigo, Alimento alimento) {
        Connection conn = connectionFactory.recuperarConexao();
        return new AlimentoDAO(conn, connectionFactory).atualizar(codigo, alimento);
    }

    */
}
