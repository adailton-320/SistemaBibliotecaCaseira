package sistemaBiblioteca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistemaBiblioteca.daoGenerico.DaoGenerico;
import sistemaBiblioteca.model.Usuario;

@ManagedBean(name= "usuariobean")
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuario= new Usuario();
	private DaoGenerico<Usuario> usuarioDao= new DaoGenerico<Usuario>();
	
	public String salvarUsuario() {
		
		usuarioDao.salvar(usuario);
		
		return "";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	
	
	

}
