package br.com.rpg.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.rpg.dal.ModuloConexao;
import rpg.Arma;

public class ArmaRepository {
	private Connection conexao = null;

	PreparedStatement pst = null;
	ResultSet rs = null;
	
    public ArmaRepository() {
        this.conexao = ModuloConexao.conector();
    }

    public void cadastrar() {
        // usa a conexão
    }

    public List<Arma> listar() {
        // usa a mesma conexão
    	List<Arma> lista = new ArrayList<>();
    	String sql = """
    				SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,a.facilidadeUso,a.proposito,a.dano,a.critico,a.alcance,a.tipo
    				FROM tbarma AS a, tbequipamento AS e
    				WHERE WHERE e.id=a.equipamento_id
    				""";
    	try {
    		pst=conexao.prepareStatement(sql);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			Arma a = new Arma();
    				a.id = rs.getInt("id");
    				a.nome = rs.getString("nome");
    				a.preco = rs.getInt("preco");
    				a.espacos = rs.getInt("espacos");
    				a.descricao = rs.getString("descricao");
    			    a.facilidadeUso = rs.getString("facilidadeUso");
    			    a.proposito = rs.getString("proposito");
    			    a.dano = rs.getString("dano");
    			    a.critico = rs.getString("critico");
    			    a.alcance = rs.getString("alcance");
    			    a.tipo = rs.getString("tipo");
    			    lista.add(a);
            }
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    	return lista;
    }
    
   
    public void atualizar() {
        // usa a mesma conexão
    }

    public void excluir() {
        // usa a mesma conexão
    }
}
