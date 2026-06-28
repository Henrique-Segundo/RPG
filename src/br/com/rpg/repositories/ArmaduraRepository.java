package br.com.rpg.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.rpg.dal.ModuloConexao;
import rpg.Armadura;

public class ArmaduraRepository {
	private Connection conexao = null;

	PreparedStatement pst = null;
	ResultSet rs = null;
	
    public ArmaduraRepository() {
        this.conexao = ModuloConexao.conector();
    }
	
	public List<Armadura> listar() {
        // usa a mesma conexão
    	List<Armadura> lista = new ArrayList<>();
    	String sql = """
    					SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,a.facilidadeUso,a.bonus,a.penalidade
    					FROM tbarmadura AS a, tbequipamento AS e
    					WHERE e.id=a.equipamento_id
    					""";
    	try {
    		pst=conexao.prepareStatement(sql);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			Armadura a = new Armadura();
    				a.id = rs.getInt("id");
    				a.nome = rs.getString("nome");
    				a.preco = rs.getInt("preco");
    				a.espacos = rs.getInt("espacos");
    				a.descricao = rs.getString("descricao");
    			    a.facilidadeUso = rs.getString("facilidadeUso");
    			    a.bonus= rs.getInt("bonus");
    			    a.penalidade = rs.getInt("penalidade");
    			    lista.add(a);
            }
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    	return lista;
    }
    
}
