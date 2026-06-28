package br.com.rpg.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.rpg.dal.ModuloConexao;
import rpg.IntemGeral;

public class ItemGeralRepository {
	private Connection conexao = null;

	PreparedStatement pst = null;
	ResultSet rs = null;
	
    public ItemGeralRepository() {
        this.conexao = ModuloConexao.conector();
    }
    public List<IntemGeral> listar() {
        // usa a mesma conexão
    	List<IntemGeral> lista = new ArrayList<>();
    	String sql = "SELECT * FROM tbitemgeral";
    	try {
    		pst=conexao.prepareStatement(sql);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			IntemGeral i = new IntemGeral();
    			    i.equipamento_id = rs.getInt("equipamento_id");
    			    i.efeito = rs.getString("efeito");
    			    lista.add(i);
            }
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    	return lista;
    }
    
}
