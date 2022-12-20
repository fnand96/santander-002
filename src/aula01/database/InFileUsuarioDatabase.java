package aula01.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class InFileUsuarioDatabase implements Repositorio {

    private final String FILE_NAME = "/Users/jorge/Study/letscode/santander946/santander-oo2/db/usuarios.txt";

    public GeradorDeIdContrato gerador;

    public InFileUsuarioDatabase(GeradorDeIdContrato gerador) {
        this.gerador = gerador;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        try {
            String id = gerador.gerar();
            String formatado = String.format("%s:%s\n", id, usuario.nome());
            Files.writeString(Paths.get(FILE_NAME), formatado, StandardOpenOption.APPEND);
            return new Usuario(id, usuario.nome());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario buscarPorId(String id) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(FILE_NAME));

            return linhas.stream().map(linha -> {
                        String[] split = linha.split(":");
                        return new Usuario(split[0], split[1]);
                    })
                    .filter(usuario -> usuario.id().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> todos() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(FILE_NAME));

            return linhas.stream().map(linha -> {
                String[] split = linha.split(":");
                return new Usuario(split[0], split[1]);
            }).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
