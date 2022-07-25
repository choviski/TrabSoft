
package com.mycompany.petinder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author choviski
 */
public class Comentario {
    private int id;
    private int incrementId = 1;
    private String Conteudo;
    private String data;
    private String hora;
    private Usuario usuario;
    private List<Comentario> comentario = new ArrayList<Comentario>();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public void setConteudo(String Conteudo) {
        this.Conteudo = Conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String cadastrarComentario(String conteudo, String data, String hour, Usuario usuario) {
        Comentario novoComentario = new Comentario();
        novoComentario.setId(this.incrementId);
        novoComentario.setConteudo(conteudo);
        novoComentario.setData(data);
        novoComentario.setHora(hour);
        novoComentario.setUsuario(usuario);
        if (!novoComentario.getConteudo().isEmpty()
                && !novoComentario.getData().isEmpty()
                && !novoComentario.getHora().isEmpty()
                && !novoComentario.getUsuario().toString().isEmpty()) {
            this.comentario.add(novoComentario);
            this.incrementId++;
            return ("Comentario gerado com sucesso");
        }
        return ("Erro ao gerar comentario");
    }
    
    public String removerComentario(int id, int userId) {
        int i;
        if (userId == 1) {
            for (i = 0; i < this.comentario.size(); i++) {
                if (this.comentario.get(i).getId() == id) {
                    this.comentario.remove(i);
                    return ("Comentario removido com sucesso");
                }
            }
        } else {
            for (i = 0; i < this.comentario.size(); i++) {
                if (this.comentario.get(i).getId() == id) {
                    if (this.comentario.get(i).usuario.getId() == userId) {
                        this.comentario.remove(i);
                        return ("Comentario removido com sucesso");
                    } else {
                        return ("Voce não tem Permissão para remover esse comentario");
                    }
                }
            }
        }
        return ("Voce não tem Permissão para remover esse comentario");
    }
    
    public String EditarComentario(String conteudo, String data, String hour, Usuario usuario, int idComentario) {

        for (int i = 0; i < this.comentario.size(); i++) {
            if (this.comentario.get(i).getId() == idComentario) {
                if ((usuario.getId() == this.comentario.get(i).usuario.getId()) || usuario.getId() == 1) {
                    this.comentario.get(i).setConteudo(conteudo);
                    this.comentario.get(i).setData(data);
                    this.comentario.get(i).setHora(hour);
                    return ("Comentario alterado com sucesso");
                } else {
                    return ("voce não tem autorização para editar esse comentario");
                }
            }
        }
        return ("comentario não encontrado");
    }
}
