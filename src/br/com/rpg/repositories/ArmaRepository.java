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

	public List<Arma> listar() {
		
		List<Arma> lista = new ArrayList<>();
		String sql = """
				SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,a.facilidadeUso,a.proposito,a.dano,a.critico,a.alcance,a.tipo
				FROM tbarma AS a, tbequipamento AS e
				WHERE e.id=a.equipamento_id
				""";
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Arma a = new Arma();
				a.ID = rs.getInt("id");
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return lista;
	}

	public Arma listarPorId(int id) {
		Arma arma = null;
		String sql = """
				SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,a.facilidadeUso,a.proposito,a.dano,a.critico,a.alcance,a.tipo
				FROM tbarma AS a, tbequipamento AS e
				WHERE e.id=a.equipamento_id AND e.id=?
				""";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				arma = new Arma();
				arma.ID = rs.getInt("id");
				arma.nome = rs.getString("nome");
				arma.preco = rs.getInt("preco");
				arma.espacos = rs.getInt("espacos");
				arma.descricao = rs.getString("descricao");
				arma.facilidadeUso = rs.getString("facilidadeUso");
				arma.proposito = rs.getString("proposito");
				arma.dano = rs.getString("dano");
				arma.critico = rs.getString("critico");
				arma.alcance = rs.getString("alcance");
				arma.tipo = rs.getString("tipo");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return arma;
	}

	public void adicionar(Arma arma) {
		String sql = """
						INSERT INTO tbequipamento
							(nome,preco,espacos,descricao)
								VALUES
							(?,?,?,?)
				""";
		try {
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, arma.nome);
			pst.setInt(2, arma.preco);
			pst.setInt(3, arma.espacos);
			pst.setString(4, arma.descricao);
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int equipamentoId = rs.getInt(1);
				sql = """
						 INSERT INTO tbarma
								 (equipamento_id,facilidadeUso,proposito,dano,critico,alcance,tipo)
									 VALUES
								 (?,?,?,?,?,?,?)
						""";
				pst = conexao.prepareStatement(sql);
				pst.setInt(1, equipamentoId);
				pst.setString(2, arma.facilidadeUso);
				pst.setString(3, arma.proposito);
				pst.setString(4, arma.dano);
				pst.setString(5, arma.critico);
				pst.setString(6, arma.alcance);
				pst.setString(7, arma.tipo);
				pst.executeUpdate();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void editar(int id,Arma arma) {
		String sqlEquipamento = """
					UPDATE tbequipamento
					SET nome=?, preco=?, espacos=?,descricao=?
					WHERE id=?		
					
				""";
		 String sqlArma =  """
		 				 Update tbarma
		 				 SET facilidadeUso=?,proposito=?,dano=?,critico=?,alcance=?,tipo=?
		 				 WHERE equipamento_id=?
		 			
		 				""";
		try {
			pst = conexao.prepareStatement(sqlEquipamento);
			pst.setString(1, arma.nome);
			pst.setInt(2, arma.preco);
			pst.setInt(3, arma.espacos);
			pst.setString(4, arma.descricao);
			pst.setInt(5, id);
			pst.executeUpdate();
			pst = conexao.prepareStatement(sqlArma);
			pst.setString(1, arma.facilidadeUso);
			pst.setString(2, arma.proposito);
			pst.setString(3, arma.dano);
			pst.setString(4, arma.critico);
			pst.setString(5, arma.alcance);
			pst.setString(6, arma.tipo);
			pst.setInt(7, id);
			pst.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void deletar(int id) {
		String sqlArma = """
				DELETE FROM tbarma
				WHERE equipamento_id=?
				""";
		String sqlEquipamento = """
				DELETE FROM tbequipamento
				WHERE id=?
				""";
		try {
			pst = conexao.prepareStatement(sqlArma);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst = conexao.prepareStatement(sqlEquipamento);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArmaRepository repo = new ArmaRepository();
        Arma arma = repo.listarPorId(1);
       System.out.println(arma);
    }
	
}
