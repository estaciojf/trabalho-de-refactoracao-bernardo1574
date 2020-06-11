package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Listeners.TableLivroListener;
// include para função
import Controllers.Functions;



public class ExibirController implements ActionListener {
	
	private JTable table;
	public String column[]={"Título","Autor", "Genero", "Ano", "Já Leu?"};  
	DefaultTableModel model;

	public ExibirController(JTable table) throws SQLException {
		this.table = table;
		this.model = (DefaultTableModel) table.getModel();
		this.setTableColumns();
		this.getLivros();
		
		
		TableLivroListener tableListener = new TableLivroListener(table);
		
		table.getModel().addTableModelListener(tableListener);
	}
	
	private void setTableColumns() {
		for (String columnName : this.column) {
			model.addColumn(columnName);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		this.getLivros();
		
	}
}


