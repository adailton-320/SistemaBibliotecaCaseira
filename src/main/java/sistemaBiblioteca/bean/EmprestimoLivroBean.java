package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.model.EmprestimoLivro;
import sistemaBiblioteca.model.Livro;
import sistemaBiblioteca.model.Solicitante;

@ViewScoped
@ManagedBean(name = "emprestimoLivroBean")
public class EmprestimoLivroBean {
	
	private EmprestimoLivro emprestimoLivro= new EmprestimoLivro();
	private DaoGenerico<EmprestimoLivro> genericoEmprestimo= new DaoGenerico<EmprestimoLivro>();
	private List<EmprestimoLivro> listLivrosEmprestado= new ArrayList<EmprestimoLivro>();
	
	
	public EmprestimoLivro getEmprestimoLivro() {
		return emprestimoLivro;
	}
	public void setEmprestimoLivro(EmprestimoLivro emprestimoLivro) {
		this.emprestimoLivro = emprestimoLivro;
	}
	public List<EmprestimoLivro> getListLivrosEmprestado() {
		return listLivrosEmprestado;
	}
	public void setListLivrosEmprestado(List<EmprestimoLivro> listLivrosEmprestado) {
		this.listLivrosEmprestado = listLivrosEmprestado;
	}
	
	
	
}
