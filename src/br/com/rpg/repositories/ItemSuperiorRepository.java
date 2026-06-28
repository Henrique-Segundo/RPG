package br.com.rpg.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.rpg.dal.ModuloConexao;
import rpg.ItemSuperior;

public class ItemSuperiorRepository {
	private Connection conexao = null;

	PreparedStatement pst = null;
	ResultSet rs = null;
	
    public ItemSuperiorRepository() {
        this.conexao = ModuloConexao.conector();
    }
    
    public List<ItemSuperior> listar() {
        // usa a mesma conexão
    	List<ItemSuperior> lista = new ArrayList<>();
    	String sql = "SELECT * FROM tbitemgeral";
    	try {
    		pst=conexao.prepareStatement(sql);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			ItemSuperior i = new ItemSuperior();
    			    i.id = rs.getInt("id");
    			    i.modificacao = rs.getString("modificacao");
    			    i.efeito= rs.getString("efeito");
    			    i.descricao= rs.getString("descricao");
    			    lista.add(i);
            }
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    	return lista;
    }
}
