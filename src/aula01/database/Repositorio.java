package aula01.database;

import java.util.List;

public interface Repositorio {

    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(String id);

    List<Usuario> todos();
}
