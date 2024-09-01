package sistemaBiblioteca.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.model.Usuario;

@ManagedBean(name= "usuariobean")
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuario= new Usuario();
	//private InteUsuarioServico servicoUsuario;
	private DaoGenerico<Usuario> usuarioDao= new DaoGenerico<Usuario>();
	private List<Usuario> listarUsuario= new ArrayList<Usuario>();
	
	public String salvarUsuario() {
		
		usuarioDao.mergeSalvaEditar(usuario);
		
		return "";
	}
	
	public String novoUsuario() {
		
		usuario= new Usuario();
		
		return "";
	}
	
	public String removerUsuario() {
		
		usuarioDao.deletarId(usuario);
		
		usuario= new Usuario();
		
		return "";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListarUsuario() {
		
		listarUsuario=	usuarioDao.listar(Usuario.class);
		
		return listarUsuario;
	}
	
	
	
	
	
	
	
	
	

}
