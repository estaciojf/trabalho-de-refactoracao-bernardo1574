package DAO;


public abstract class Sql_querys {

	public static final String table = "Livros";

	private String sql_select = "SELECT * FROM " + LivroDAO.table;
	private String sql_update = "UPDATE Livros SET title = '%s', author = '%s', gender= '%s', year = %s, isRead = %b WHERE id = %s";
}