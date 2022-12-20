package aula01.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class InMemoryUsuarioDatabase implements Repositorio {

    public static Map<String, Usuario> db_usuarios = new HashMap<>();
    public GeradorDeIdContrato gerador;

    public InMemoryUsuarioDatabase(GeradorDeIdContrato gerador) {
        this.gerador = gerador;
    }

    public Usuario salvar(Usuario usuario) {
        String id = gerador.gerar();
        Usuario usuarioSalvar = new Usuario(id, usuario.nome());
        db_usuarios.put(id, usuarioSalvar);
        return usuarioSalvar;
    }

    public Usuario buscarPorId(String id) {
        Usuario usuario = db_usuarios.get(id);
        return usuario;
    }

    public List<Usuario> todos() {
        return new ArrayList<>(db_usuarios.values());
    }

}
