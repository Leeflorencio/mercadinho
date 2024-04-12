package com.br.mercado.service;

import com.br.mercado.ConnectionFactory;
import com.br.mercado.dao.LimpezaDAO;
import com.br.mercado.domain.Limpeza;

import java.sql.Connection;
import java.util.Set;

public class LimpezaService {

    private ConnectionFactory connectionFactory;

    public LimpezaService() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastroProdutoLimpeza(Limpeza limpeza) {
        Connection conn = connectionFactory.recuperarConexao();
        new LimpezaDAO(conn).cadastrarProdutoLimpeza(limpeza);
    }

    public void excluirProdutoLimpeza(Long codigo) {
        Connection conn = connectionFactory.recuperarConexao();
        new LimpezaDAO(conn).excluir(codigo);
    }

    public Set<Limpeza> listarProdutosLimpeza() {
        Connection conn = connectionFactory.recuperarConexao();
        return new LimpezaDAO(conn).listar();
    }

    public Limpeza buscarPorCodigo(Long identificador) {
        Connection conn = connectionFactory.recuperarConexao();
        return new LimpezaDAO(conn).buscarProdutoLimpeza(identificador);
    }

}
