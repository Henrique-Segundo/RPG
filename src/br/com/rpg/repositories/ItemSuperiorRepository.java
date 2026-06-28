package br.com.rpg.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemSuperior i = new ItemSuperior();
				i.id = rs.getInt("id");
				i.modificacao = rs.getString("modificacao");
				i.efeito = rs.getString("efeito");
				i.descricao = rs.getString("descricao");
				lista.add(i);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public ItemSuperior listarPorId(int id) {
		ItemSuperior item = null;
		String sql = "SELECT * FROM tbitemsuperior WHERE id=?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				item = new ItemSuperior();
				item.id = rs.getInt("id");
				item.modificacao = rs.getString("modificacao");
				item.efeito = rs.getString("efeito");
				item.descricao = rs.getString("descricao");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return item;
	}

	public void adicionar(ItemSuperior itemSuperior) {
		String sql = """
				INSERT INTO tbitemsuperior
							(modificacao,efeito,descricao)
							VALUES
							(?,?,?)
				""";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, itemSuperior.modificacao);
			pst.setString(2, itemSuperior.efeito);
			pst.setString(3, itemSuperior.descricao);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void editar(int id, ItemSuperior itemSuperior) {
		String sql = """
					UPDATE tbitemsuperior
					SET modificacao=?, efeito=?, descricao=?
					WHERE id=?

				""";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, itemSuperior.modificacao);
			pst.setString(2, itemSuperior.efeito);
			pst.setString(3, itemSuperior.descricao);
			pst.setInt(4, id);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(int id) {
		String sql = """
				DELETE FROM tbitemsuperior
				WHERE id=?
				""";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
