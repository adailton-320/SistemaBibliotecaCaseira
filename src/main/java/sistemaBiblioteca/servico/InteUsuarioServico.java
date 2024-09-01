package sistemaBiblioteca.servico;

import sistemaBiblioteca.model.Usuario;

public interface InteUsuarioServico {
	
	Usuario usuario= new Usuario();
	
	public void salvarUsuario();
	public Usuario salvaEditarUsuario();
	public Usuario pesquUsuario();
	public void deletarUsuario();
	
	

}
