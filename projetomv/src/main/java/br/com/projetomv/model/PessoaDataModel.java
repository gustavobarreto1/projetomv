package br.com.projetomv.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.projetomv.dao.CrudDao;

public class PessoaDataModel extends AbstractTableModel{

	private static final long serialVersionUID = -1476728026859694368L;

	private String[] colunas = { "PersonalId", "Nome", "Telefone", "Email", "RG", "Sexo" };
	private String[][] data;

	private CrudDao crudDao = new CrudDao();

	public PessoaDataModel() {
		this.loadData();
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

	@Override
	public int getRowCount() {
		return this.data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	public void loadData() {
		List<Pessoa> pessoas = this.crudDao.relatorio();
		String[][] data = new String[pessoas.size()][6];

		for (int i = 0; i < pessoas.size(); i++) {
			data[i][0] = pessoas.get(i).getPersonalId();
			data[i][1] = pessoas.get(i).getNome();
			data[i][2] = pessoas.get(i).getEmail();
			data[i][3] = pessoas.get(i).getRg();
			data[i][4] = pessoas.get(i).getTelefone();
			data[i][5] = pessoas.get(i).getSexo();
		}

		this.data = data;
	}

}
