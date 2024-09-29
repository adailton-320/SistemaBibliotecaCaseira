package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.daoGenerico.LivroDaoGenerico;
import sistemaBiblioteca.model.Livro;
import sistemaBiblioteca.model.Solicitante;

@ManagedBean(name = "livroBean")
@ViewScoped
public class LivroBean {
	private Livro livro= new Livro();
	private LivroDaoGenerico<Livro> livroDao= new LivroDaoGenerico<Livro>();
	private List<Livro> listarLivros= new ArrayList<Livro>();
	private String campoPesquisa;
	
	@PostConstruct
	public void init() {
		listarLivros= livroDao.listar(Livro.class);
	}
	
	public void abrirDialogoPesquisa() {
		
		HashMap<String, Object> opcoes= new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("pesquisarLivros", opcoes, null);
		
	}
	
	public void selecionarLivro(Livro livro) {

		RequestContext.getCurrentInstance().closeDialog(livro);

	}
	
	public String salvaLivro() {
		livroDao.mergeSalvaEditar(livro);
		listarLivros.add(livro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação","Salvo com sucesso!!"));
		
		return "";
	}
	
	public String limpaFormulario() {
		livro= new Livro();
		
		return "";
	}
	
	public String removeLivro() {
		
		livroDao.deletarId(livro);
		listarLivros.remove(livro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Removido com sucesso!!"));
		
		return "";
	}
	
	public void pesquisarLivros() {
		listarLivros= livroDao.pesquisar(campoPesquisa);
	}
	
	public void livroSelecionado() {
		
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
	
	public String getCampoPesquisa() {
		return campoPesquisa;
	}
	
	public void setCampoPesquisa(String campoPesquisa) {
		this.campoPesquisa = campoPesquisa;
	}
	
	
}
