package Controllers;

import Models.Livro;
import DAO.LivroDAO;

public abstract class Functions{

	public void cadastrarLivro() {
		
		Livro livro = new Livro(
				this.fieldTitle.getText(), 
				this.fieldAuthor.getText(),
				this.comboGender.getSelectedItem().toString(),
				Integer.parseInt(this.comboYear.getSelectedItem().toString()),
				this.isRead.isSelected()
				);
		
		listLivros.add(livro);
		
		for (int i = 0 ; i < listLivros.size() ; i ++ ) {
			System.out.println(listLivros.get(i).toString());
		}
		
	}

	public String getLivros() {
		
		this.model.setRowCount(0);
		

		try {
			LivroDAO livroDao = new LivroDAO();
			List<Livro> list = livroDao.getAllLivros();
			
			for (Livro livro : list) {
				model.addRow(new Object[] {
						livro.getTitle(),
						livro.getAuthor(),
						livro.getGender(),
						livro.getYear(),
						livro.isRead()
				});
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void abrirExibirView() {
		LivroDAO livroDao;
		try {
			livroDao = new LivroDAO();
			System.out.println(livroDao.getAllLivros());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
