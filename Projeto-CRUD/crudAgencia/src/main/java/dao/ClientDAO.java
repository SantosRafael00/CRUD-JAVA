package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Client;

public class ClientDAO {

	private Connection connection;
	private String sql;

	public ClientDAO() throws SQLException {
		connection = DatabaseConnection.createConnection();
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createClient(Client client) {
		sql = "INSERT INTO Cliente (nome,dataNasc,login,senha) VALUES (?,?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, client.getNome());
			Date data = Date.valueOf(client.getDataNasc());
			stmt.setDate(2, data);
			stmt.setString(3, client.getLogin());
			stmt.setString(4, client.getSenha());

			

			stmt.executeUpdate();

			System.out.println("Cliente criado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Client findClient(int id) {
		Client client = null;
		sql = "SELECT * FROM Cliente WHERE id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();

			if (r.next()) {
			Client	c = new Client();
				c.setId(r.getInt("id"));
				c.setNome(r.getString("nome"));
				c.setDataNasc(r.getDate("dataNasc").toLocalDate());
				c.setLogin(r.getString("login"));
				c.setSenha(r.getString("senha"));
			
				
				return c;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return client;
	}
	
	
	
	public List<Client> findClients() {

		String sql = "SELECT * FROM cliente";

		List<Client> clients = new ArrayList<Client>();

		ResultSet r = null;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			r = stmt.executeQuery();

			while (r.next()) {
				Client client = new Client();
				client = new Client();
				client.setId(r.getInt("id"));
				client.setNome(r.getString("nome"));
				client.setDataNasc(r.getDate("dataNasc").toLocalDate());
				client.setLogin(r.getString("login"));
				client.setSenha(r.getString("senha"));
				

				clients.add(client);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return clients;

	}
	
	
	

	public void updateClient(Client client) {
		sql = "UPDATE Cliente SET nome = ?, dataNasc = ?, login = ?, senha = ?  WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, client.getNome());
			Date sqlDate = Date.valueOf(client.getDataNasc());
			stmt.setDate(2, sqlDate);
			stmt.setString(3, client.getLogin());
			stmt.setString(4, client.getSenha());
			stmt.setInt(5, client.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteClient(int id) {
		sql = "DELETE FROM Cliente WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();

			System.out.println("Cliente Deletado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
