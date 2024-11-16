package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.daoGenerico.EmprestimoDaoGenerico;
import sistemaBiblioteca.daoGenerico.SolicitanteDaoGenerico;
import sistemaBiblioteca.model.EmprestimoLivro;
import sistemaBiblioteca.model.Livro;
import sistemaBiblioteca.model.Solicitante;

@ViewScoped
@ManagedBean(name = "emprestimoLivroBean")
public class EmprestimoLivroBean {

	private Solicitante solicitante= new Solicitante();
	private SolicitanteDaoGenerico<Solicitante> solicitanteDaoGenerico= new SolicitanteDaoGenerico<Solicitante>();
	private EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
	private EmprestimoDaoGenerico<EmprestimoLivro> genericoEmprestimo = new EmprestimoDaoGenerico<EmprestimoLivro>();
	private List<EmprestimoLivro> listLivrosEmprestado = new ArrayList<EmprestimoLivro>();

	

	public void solicitanteSelecionado(SelectEvent evento) {
		
		Solicitante solicitante = (Solicitante) evento.getObject();
		emprestimoLivro.setSolicitante(solicitante);

	}
	
	public void livroSelecionado(SelectEvent evento) {
		Livro livro = (Livro) evento.getObject();
		emprestimoLivro.setLivro(livro);

	}
	

	public String registrarEmprestimo(){
		
		genericoEmprestimo.mergeSalvaEditar(emprestimoLivro);
		
		
		
		return "";
	}
	
	public String novoEmprestimo() {
		
		emprestimoLivro = new EmprestimoLivro();
		
		return "";
	}

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
	
	public EmprestimoDaoGenerico<EmprestimoLivro> getGenericoEmprestimo() {
		return genericoEmprestimo;
	}
	
	public void setGenericoEmprestimo(EmprestimoDaoGenerico<EmprestimoLivro> genericoEmprestimo) {
		this.genericoEmprestimo = genericoEmprestimo;
	}

}
