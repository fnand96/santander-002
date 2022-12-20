package aula01;

import aula01.database.GeradorDeIdContrato;
import aula01.database.GeradorDeIdNome;
import aula01.database.GeradorDeNumerosAleatorio;
import aula01.database.GeradorDeUUID;
import aula01.database.InFileUsuarioDatabase;
import aula01.database.InMemoryUsuarioDatabase;
import aula01.database.Repositorio;
import aula01.database.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Usuario usuario = new Usuario("1", "joao");
        Usuario usuario1 = new Usuario("2", "Jaqueline");
        Usuario usuario2 = new Usuario("3", "maria");

        GeradorDeIdContrato impl = new GeradorDeUUID();

        Repositorio repo = new InFileUsuarioDatabase(impl);

        // salvando um usuario
        repo.salvar(usuario);
        Usuario usuarioSalvo = repo.salvar(usuario1);
        repo.salvar(usuario2);

        // buscando todos os usuarios
        List<Usuario> usuarios = repo.todos();
        System.out.println(usuarios);

        // buscando usuario por id
        String id = usuarioSalvo.id();
        Usuario usuarioBuscado = repo.buscarPorId(id);
        System.out.println(usuarioBuscado);

    }
}