package com.mycompany.petinder;
import com.mycompany.petinder.Mail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author choviski
 */
public class Usuario {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Usuario> usuarios = new ArrayList<Usuario>();
    private int idIncrement = 1;
    private int id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String cadastrarUsuario(String nome, String email, String login, String senha) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setId(this.idIncrement);
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setLogin(login);
        novoUsuario.setSenha(senha);
        if (!novoUsuario.getNome().isEmpty()
                && !novoUsuario.getEmail().isEmpty()
                && !novoUsuario.getLogin().isEmpty()
                && !novoUsuario.getSenha().isEmpty()) {
            this.idIncrement++;
            this.usuarios.add(novoUsuario);
            return ("Usuario cadastrado com Sucesso");
        }
        return ("Erro ao cadastrar usuario, algum campo está nulo");
    }

    public String recuperarSenha(String email) {
        if (Mail.send(email)) {
            return ("email Enviado com sucesso");
        }
        return ("erro ao enviar email");
    }

    public String removeUsuario(int id, int admId) {
        int i;
        if (admId == 1) {
            for (i = 0; i < this.usuarios.size(); i++) {
                if (usuarios.get(i).getId() == id) {
                    this.usuarios.remove(i);
                    return ("usuario Removido com sucesso");
                }
            }
        }
        return ("Voce não tem permissão para Remover esse usuario");
    }
}
