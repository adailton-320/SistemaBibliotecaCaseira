package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.model.EmprestimoLivro;
import sistemaBiblioteca.model.Livro;
import sistemaBiblioteca.model.Solicitante;

@ViewScoped
@ManagedBean(name = "emprestimoLivroBean")
public class EmprestimoLivroBean {

	private EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
	private DaoGenerico<EmprestimoLivro> genericoEmprestimo = new DaoGenerico<EmprestimoLivro>();
	private List<EmprestimoLivro> listLivrosEmprestado = new ArrayList<EmprestimoLivro>();

	

	public void solicitanteSelecionado(SelectEvent evento) {
		Solicitante solicitante = (Solicitante) evento.getObject();
		emprestimoLivro.setSolicitante(solicitante);

	}
	

	public String registrarEmprestimo() {
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

}
