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
    	String sql = "SELECT * FROM tbarmadura";
    	try {
    		pst=conexao.prepareStatement(sql);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			Armadura a = new Armadura();
    			    a.equipamento_id = rs.getInt("equipamento_id");
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
