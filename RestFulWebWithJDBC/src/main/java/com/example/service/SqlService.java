package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.dao.JdbcConnector;
import com.example.entity.ScoreSheet;

@Service
public class SqlService {

	private JdbcConnector jdbcConnector = JdbcConnector.getInstance();

	public ArrayList<ScoreSheet> getAll() throws SQLException {
		Connection connection = jdbcConnector.getConnection();
		Statement statement = connection.createStatement();
		//String sql = "select * from movies";
		String sql = "select * from movie";
		ResultSet resultSet = statement.executeQuery(sql);

		ArrayList<ScoreSheet> resultList = new ArrayList<>();
		while (resultSet.next()) {
			ScoreSheet scoreSheet = new ScoreSheet(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4));

			resultList.add(scoreSheet);
		}

		return resultList;

	}

	public ArrayList<ScoreSheet> getScoreSheetByCondition(String condtionType, String value) throws SQLException{
		
		Connection connection = jdbcConnector.getConnection();
		Statement statement = connection.createStatement();
//		String sql = "select * from movies where " + condtionType + " = \"" + value + "\"";
		String sql = "select * from movie where " + condtionType + " = \"" + value + "\"";
		System.out.println("sql : " + sql);
		ResultSet resultSet = statement.executeQuery(sql);
		
		ArrayList<ScoreSheet> resultList = new ArrayList<ScoreSheet>();
		while(resultSet.next()) {
			resultList.add(new ScoreSheet(resultSet.getInt(1), resultSet.getString(2), 
					resultSet.getString(3), resultSet.getDouble(4)));
		}
			
		return resultList;
	}
	
	public boolean insert(int id, String name, String info, double score) throws SQLException {

		Connection connection = jdbcConnector.getConnection();
		Statement statement = connection.createStatement();
//		String sql = "insert into movies(id, name, info, score) values(" + id + ",'" + name + "','" + info + "',"
//				+ score + ")";
		String sql = "insert into movie(id, name, info, score) values(" + id + ",'" + name + "','" + info + "',"
				+ score + ")";

		return (statement.executeUpdate(sql) == 1) ? true : false;
	}

	public String update(int id, String name, String info, double score) throws SQLException {

		Connection connection = jdbcConnector.getConnection();
		Statement statement = connection.createStatement();
//		String sql = "update movies set name = '" + name + "', info = '" + info + "', score = " + score + "where id = "
//				+ id;
		String sql = "update movie set name = '" + name + "', info = '" + info + "', score = " + score + "where id = "
				+ id;


		return (statement.executeUpdate(sql) == 1) ? "success" : "fail";
	}

	public boolean delete(int id) throws SQLException {

		Connection connection = jdbcConnector.getConnection();
		Statement statement = connection.createStatement();
		//String sql = "delete from movies where id = " + id;
		String sql = "delete from movie where id = " + id;

		int result = statement.executeUpdate(sql);

		return (result == 1) ? true : false;
	}

	public ScoreSheet getScoreSheetById(int id) throws SQLException {
		Connection connection = jdbcConnector.getConnection();
		Statement statement = connection.createStatement();
		//String sql = "select * from movies where id = " + id;
		String sql = "select * from movie where id = " + id;
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			return new ScoreSheet(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4));
		}
		
		return new ScoreSheet();
	}
}
