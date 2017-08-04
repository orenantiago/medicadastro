package br.com.renan.medicadastro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.renan.medicadastro.jdbc.ConnectionFactory;
import br.com.renan.medicadastro.modelo.Exame;
import br.com.renan.medicadastro.modelo.Paciente;

@Repository
public class ExameDao {
	private Connection connection;

	public ExameDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		//this.connection = dataSource.getConnection();
	}
	
	public void adiciona(Exame exame) {
		String sql = "insert into exame(idPaciente, nome, descricao, data) "
				+ "values(?,?,?,?)";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//stmt.setLong(1, exame.getPaciente().getId());
			stmt.setLong(1, 1);
			stmt.setString(2, exame.getNome());
			stmt.setString(3, exame.getDescricao());
			stmt.setDate(4,new Date(exame.getData()
					.getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Exame> lista () throws SQLException {
		List<Exame> lista = new ArrayList<Exame>();
		PreparedStatement stmt = this.connection.prepareStatement("select * from exame");
		PacienteDao pacienteDao = new PacienteDao();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Exame exame = new Exame();
			exame.setId(rs.getInt("id"));
			exame.setNome(rs.getString("nome"));
			exame.setDescricao(rs.getString("descricao"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			exame.setData(data);
			exame.setPaciente(pacienteDao.getPaciente(rs.getLong("idPaciente")));
			lista.add(exame);
		}
		stmt.close();
		rs.close();
		return lista;
	}
	
	public Exame getExame(long id) throws SQLException {
		Exame exame = new Exame();
		PreparedStatement stmt = this.connection.prepareStatement("select * from exame where id=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			exame.setId(rs.getLong("id"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			exame.setData(data);
			exame.setDescricao(rs.getString("descricao"));
			
			Paciente paciente = new PacienteDao().getPaciente(rs.getLong("idPaciente"));
			
			exame.setPaciente(paciente);
			stmt.close();
			rs.close();
		}
		return exame;
	}

	public void remove(Exame exame) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("delete from exame where id=" 
				+ String.valueOf(exame.getId()));
		stmt.execute();
		stmt.close();
	}
	
	public void altera(Exame exame) throws SQLException {
		String sql = "update exame set nome=?, descricao=?, data=?, idPaciente=? where id=?";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, exame.getNome());
		stmt.setString(2, exame.getDescricao());
		stmt.setDate(3,new Date(exame.getData()
				.getTimeInMillis()));
		stmt.setLong(4, exame.getPaciente().getId());
		stmt.setLong(5, exame.getId());
		
		stmt.execute();
		
	}

}
