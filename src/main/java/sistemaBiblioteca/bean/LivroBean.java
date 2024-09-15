package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.model.Livro;

@ManagedBean(name = "livroBean")
@ViewScoped
public class LivroBean {
	private Livro livro= new Livro();
	private DaoGenerico<Livro> livroDao= new DaoGenerico<Livro>();
	private List<Livro> listarLivros= new ArrayList<Livro>();
	
	@PostConstruct
	public void init() {
		listarLivros= livroDao.listar(Livro.class);
	}
	
	public String salvaLivro() {
		livroDao.mergeSalvaEditar(livro);
		listarLivros.add(livro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação","Salvo com sucesso!!"));
		
		return "";
	}
	
	public String removeLivro() {
		
		livroDao.deletarId(livro);
		listarLivros.remove(livro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Removido com sucesso!!"));
		
		return "";
	}
	
	public String limpaFormulario() {
		livro= new Livro();
		
		return "";
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getListarLivros() {
		return listarLivros;
	}

	public void setListarLivros(List<Livro> listarLivros) {
		this.listarLivros = listarLivros;
	}
	
	
}
