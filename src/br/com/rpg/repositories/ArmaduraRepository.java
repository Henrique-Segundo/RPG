package br.com.rpg.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.rpg.dal.ModuloConexao;
import rpg.Arma;
import rpg.Armadura;

public class ArmaduraRepository {
	private Connection conexao = null;

	PreparedStatement pst = null;
	ResultSet rs = null;

	public ArmaduraRepository() {
		this.conexao = ModuloConexao.conector();
	}

	public List<Armadura> listar() {

		List<Armadura> lista = new ArrayList<>();
		String sql = """
				SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,a.facilidadeUso,a.bonus,a.penalidade
				FROM tbarmadura AS a, tbequipamento AS e
				WHERE e.id=a.equipamento_id
				""";
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Armadura a = new Armadura();
				a.id = rs.getInt("id");
				a.nome = rs.getString("nome");
				a.preco = rs.getInt("preco");
				a.espacos = rs.getInt("espacos");
				a.descricao = rs.getString("descricao");
				a.facilidadeUso = rs.getString("facilidadeUso");
				a.bonus = rs.getInt("bonus");
				a.penalidade = rs.getInt("penalidade");
				lista.add(a);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public Armadura listarPorId(int id) {
		Armadura armadura = null;
		String sql = """
				SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,a.facilidadeUso,a.bonus,a.penalidade
				FROM tbarmadura AS a, tbequipamento AS e
				WHERE e.id=a.equipamento_id AND e.id=?
				""";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				armadura = new Armadura();
				armadura.id = rs.getInt("id");
				armadura.nome = rs.getString("nome");
				armadura.preco = rs.getInt("preco");
				armadura.espacos = rs.getInt("espacos");
				armadura.descricao = rs.getString("descricao");
				armadura.facilidadeUso = rs.getString("facilidadeUso");
				armadura.bonus = rs.getInt("bonus");
				armadura.penalidade = rs.getInt("penalidade");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return armadura;
	}

	public void adicionar(Armadura armadura) {
		String sql = """
						INSERT INTO tbequipamento
							(nome,preco,espacos,descricao)
								VALUES
							(?,?,?,?)
				""";
		try {
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, armadura.nome);
			pst.setInt(2, armadura.preco);
			pst.setInt(3, armadura.espacos);
			pst.setString(4, armadura.descricao);
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int equipamentoId = rs.getInt(1);
				sql = """
						 INSERT INTO tbarmadura
								 (equipamento_id,facilidadeuso,bonus,penalidade)
									 VALUES
								 (?,?,?,?)
						""";
				pst = conexao.prepareStatement(sql);
				pst.setInt(1, equipamentoId);
				pst.setString(2, armadura.facilidadeUso);
				pst.setInt(3, armadura.bonus);
				pst.setInt(4, armadura.penalidade);
				pst.executeUpdate();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void editar(int id,Armadura armadura) {
		String sqlEquipamento = """
					UPDATE tbequipamento
					SET nome=?, preco=?, espacos=?,descricao=?
					WHERE id=?		
					
				""";
		 String sqlArmadura =  """
		 				 Update tbarmadura
		 				 SET facilidadeUso=?,bonus=?,penalidade=?
		 				 WHERE equipamento_id=?
		 			
		 				""";
		try {
			pst = conexao.prepareStatement(sqlEquipamento);
			pst.setString(1, armadura.nome);
			pst.setInt(2, armadura.preco);
			pst.setInt(3, armadura.espacos);
			pst.setString(4, armadura.descricao);
			pst.setInt(5, id);
			pst.executeUpdate();
			pst = conexao.prepareStatement(sqlArmadura);
			pst.setString(1, armadura.facilidadeUso);
			pst.setInt(2, armadura.bonus);
			pst.setInt(3, armadura.penalidade);
			pst.setInt(4, id);
			pst.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(int id) {
		String sqlArmadura = """
				DELETE FROM tbarmadura
				WHERE equipamento_id=?
				""";
		String sqlEquipamento = """
				DELETE FROM tbequipamento
				WHERE id=?
				""";
		try {
			pst = conexao.prepareStatement(sqlArmadura);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst = conexao.prepareStatement(sqlEquipamento);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
