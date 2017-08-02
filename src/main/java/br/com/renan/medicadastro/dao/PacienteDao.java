package br.com.renan.medicadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.renan.medicadastro.jdbc.ConnectionFactory;
import br.com.renan.medicadastro.modelo.Paciente;

@Repository
public class PacienteDao {
	private Connection connection;

	@Autowired
	public PacienteDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		//this.connection = dataSource.getConnection();
	}
	
	public void adiciona(Paciente paciente) {
		String sql = "insert into paciente(nome, idade, sexo) "
				+ "values(?,?,?)";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, paciente.getNome());
			stmt.setInt(2, paciente.getIdade());
			stmt.setString(3, paciente.getSexo());
			
			stmt.execute();
			
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
