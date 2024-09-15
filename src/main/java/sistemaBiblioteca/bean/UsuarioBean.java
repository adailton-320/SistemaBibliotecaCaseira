package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.model.Usuario;

@ManagedBean(name= "usuariobean")
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuario= new Usuario();
	private DaoGenerico<Usuario> usuarioDao= new DaoGenerico<Usuario>();
	private List<Usuario> listarUsuario= new ArrayList<Usuario>();
	
	@PostConstruct
	public void init() {
		listarUsuario=	usuarioDao.listar(Usuario.class);
	}
	
	public String salvarUsuario() {
		
		usuarioDao.mergeSalvaEditar(usuario);
		listarUsuario.add(usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Salvo com sucesso"));
		
		return "";
	}
	
	public String novoUsuario() {
		
		usuario= new Usuario();
		
		return "";
	}
	
	public String removerUsuario() {
		
		usuarioDao.deletarId(usuario);
		listarUsuario.remove(usuario);
		usuario= new Usuario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"informação","Deletado com sucesso"));
		
		
		return "";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListarUsuario() {
		
		return listarUsuario;
	}
	
	
	
	
	
	
	
	
	

}
