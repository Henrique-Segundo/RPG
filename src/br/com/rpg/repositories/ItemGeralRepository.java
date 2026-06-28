package br.com.rpg.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.rpg.dal.ModuloConexao;
import rpg.ItemGeral;

public class ItemGeralRepository {
	private Connection conexao = null;

	PreparedStatement pst = null;
	ResultSet rs = null;

	public ItemGeralRepository() {
		this.conexao = ModuloConexao.conector();
	}

	public List<ItemGeral> listar() {
		
		List<ItemGeral> lista = new ArrayList<>();
		String sql = """
				 SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,i.efeito
				 FROM tbitemgeral AS i, tbequipamento AS e
				 WHERE e.id=i.equipamento_id

				""";
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGeral i = new ItemGeral();
				i.ID = rs.getInt("id");
				i.nome = rs.getString("nome");
				i.preco = rs.getInt("preco");
				i.espacos = rs.getInt("espacos");
				i.descricao = rs.getString("descricao");
				i.efeito = rs.getString("efeito");
				lista.add(i);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public ItemGeral listarPorId(int id) {
		ItemGeral item = null;
		String sql = """
				SELECT e.id,e.nome,e.preco,e.espacos,e.descricao,i.efeito
				FROM tbitemgeral AS i, tbequipamento AS e
				WHERE e.id=i.equipamento_id AND e.id=?
				""";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				item = new ItemGeral();
				item.ID = rs.getInt("id");
				item.nome = rs.getString("nome");
				item.preco = rs.getInt("preco");
				item.espacos = rs.getInt("espacos");
				item.descricao = rs.getString("descricao");
				item.efeito = rs.getString("efeito");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return item;
	}

	public void adicionar(ItemGeral item) {
		String sql = """
						INSERT INTO tbequipamento
							(nome,preco,espacos,descricao)
								VALUES
							(?,?,?,?)
				""";
		try {
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, item.nome);
			pst.setInt(2, item.preco);
			pst.setInt(3, item.espacos);
			pst.setString(4, item.descricao);
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int equipamentoId = rs.getInt(1);
				sql = """
						 INSERT INTO tbitemgeral
								 (equipamento_id,efeito)
									 VALUES
								 (?,?)
						""";
				pst = conexao.prepareStatement(sql);
				pst.setInt(1, equipamentoId);
				pst.setString(2, item.efeito);
				pst.executeUpdate();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void editar(int id, ItemGeral item) {
		String sqlEquipamento = """
					UPDATE tbequipamento
					SET nome=?, preco=?, espacos=?,descricao=?
					WHERE id=?

				""";
		String sqlItem = """
				 Update tbitemgeral
				 SET efeito=?
				 WHERE equipamento_id=?

				""";
		try {
			pst = conexao.prepareStatement(sqlEquipamento);
			pst.setString(1, item.nome);
			pst.setInt(2, item.preco);
			pst.setInt(3, item.espacos);
			pst.setString(4, item.descricao);
			pst.setInt(5, id);
			pst.executeUpdate();
			pst = conexao.prepareStatement(sqlItem);
			pst.setString(1, item.efeito);
			pst.setInt(2, id);
			pst.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(int id) {
		String sqlItem = """
				DELETE FROM tbitemgeral
				WHERE equipamento_id=?
				""";
		String sqlEquipamento = """
				DELETE FROM tbequipamento
				WHERE id=?
				""";
		try {
			pst = conexao.prepareStatement(sqlItem);
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
