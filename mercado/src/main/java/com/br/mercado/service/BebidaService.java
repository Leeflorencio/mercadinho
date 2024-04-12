package com.br.mercado.service;

import com.br.mercado.ConnectionFactory;
import com.br.mercado.dao.AlimentoDAO;
import com.br.mercado.dao.BebidaDAO;
import com.br.mercado.domain.Alimento;
import com.br.mercado.domain.Bebida;

import java.sql.Connection;
import java.util.Set;

public class BebidaService {

    private ConnectionFactory connectionFactory;

    public BebidaService(){
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastroBebida(Bebida bebida){
        Connection conn = connectionFactory.recuperarConexao();
        new BebidaDAO(conn).cadastrarBebida(bebida);
    }

    public void excluirBebida(Long codigo){
        Connection conn = connectionFactory.recuperarConexao();
        new BebidaDAO(conn).excluir(codigo);
    }

    public Set<Bebida> listarTodas(){
        Connection conn = connectionFactory.recuperarConexao();
        return new BebidaDAO(conn).listar();
    }

    public Bebida buscarPorCodigo(Long identificador){
        Connection conn = connectionFactory.recuperarConexao();
        return new BebidaDAO(conn).buscarBebida(identificador);
    }
}
