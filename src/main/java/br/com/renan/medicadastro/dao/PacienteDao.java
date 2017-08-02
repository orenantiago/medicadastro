package br.com.renan.medicadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Paciente> lista () throws SQLException {
		List<Paciente> lista = new ArrayList<Paciente>();
		PreparedStatement stmt = this.connection.prepareStatement("select * from paciente");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Paciente paciente = new Paciente();
			paciente.setId(rs.getInt("id"));
			paciente.setNome(rs.getString("nome"));
			paciente.setIdade(rs.getInt("idade"));
			paciente.setSexo(rs.getString("sexo"));
			
			lista.add(paciente);
		}
		
		stmt.close();
		rs.close();
		return lista;
	}
	
	public Paciente getPaciente(long id) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("select * from paciente where id=?");
		stmt.setString(1, String.valueOf(id));
		ResultSet rs = stmt.executeQuery();
		
		Paciente paciente = new Paciente();
		paciente.setId(rs.getLong("id"));
		paciente.setNome(rs.getString("nome"));
		paciente.setIdade(rs.getInt("idade"));
		paciente.setSexo(rs.getString("sexo"));
		
		stmt.close();
		rs.close();
		
		return paciente;
		
	}
}
