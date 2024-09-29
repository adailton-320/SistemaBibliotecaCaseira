package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sistemaBiblioteca.daoGenerico.SolicitanteDaoGenerico;
import sistemaBiblioteca.model.Solicitante;

@ViewScoped
@ManagedBean(name = "solicitantebean")
public class SolicitanteEmprestimoBean {
	
	private Solicitante solicitante= new Solicitante();
	private SolicitanteDaoGenerico solicitanteDao= new SolicitanteDaoGenerico();
	private List<Solicitante> listarSolicitante= new ArrayList<Solicitante>();
	private String campoPesquisa;
	
	@PostConstruct
	public void init() {
		listarSolicitante= solicitanteDao.listar(Solicitante.class);
	}
	
	public String salvarSolicitante() {
		
		solicitanteDao.mergeSalvaEditar(solicitante);
		listarSolicitante.add(solicitante);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação","Salvo com sucesso!!"));
		
		
		return "";
	}
	
	public void pesquisarSolicitante() {
		listarSolicitante= solicitanteDao.pesquisar(campoPesquisa);
	}
	
	public String novoCadastro() {
		
		solicitante= new Solicitante();
		
		
		
		return "";
	}
	
	
	
	public Solicitante getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	} 
	
	public List<Solicitante> getListarSolicitante() {
		return listarSolicitante;
	}
	
	public void setListarSolicitante(List<Solicitante> listarSolicitante) {
		this.listarSolicitante = listarSolicitante;
	}
	
	public String getCampoPesquisa() {
		return campoPesquisa;
	}
	
	public void setCampoPesquisa(String campoPesquisa) {
		this.campoPesquisa = campoPesquisa;
	}
    
	
}
