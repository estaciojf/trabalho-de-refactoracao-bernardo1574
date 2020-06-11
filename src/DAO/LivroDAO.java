package DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import Enum.EDataBase;
import DAO.Sql_querys;

import Models.Livro;

public class LivroDAO extends DAO {
	
	
	public LivroDAO() throws SQLException {
		super();	
	}
	
	public List<Livro> getAllLivros() throws SQLException {
		
		List<Livro> list = new ArrayList<>();
		
		Statement myStat = null;
		ResultSet myResult = null;
		
		myStat = DAO.getConnection().createStatement();
		// inclui a query de select na sql_querys, para assim caso preciso mudar a query ou chama-la futuramente em alguma outra função, simplesmente só colocaria a variável.
		myResult = myStat.executeQuery(sql_select);
				
		while (myResult.next()) {
			Livro tempLivro = new Livro(
					myResult.getString("title"),
					myResult.getString("author"),
					myResult.getString("gender"),
					myResult.getInt("year"),
					myResult.getBoolean("isRead")
					);
			
			list.add(tempLivro);
		}
		

		Random random = new Random();
		int randomize = random.nextInt(list.size() - 1);
		
		list.get(randomize).getAuthor();
		
		
		
		myStat.close();
		return list;
		
	}
	
	
	public void updateLivroById(int id, Livro livro) throws SQLException {
		
		List<Livro> list = new ArrayList<>();
		
		Statement myStat = null;
		ResultSet myResult = null;
		
		myStat = DAO.getConnection().createStatement();
		String query = String.format(sql_update, 
			livro.getTitle(), livro.getAuthor(), livro.getGender(), livro.getYear(), livro.isRead(), id);

		myStat.executeUpdate(query);
		
		
		myStat.close();
		
	}
}
