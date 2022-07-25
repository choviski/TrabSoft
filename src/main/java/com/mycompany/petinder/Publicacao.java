package com.mycompany.petinder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author choviski
 */
public class Publicacao {

    private int id;
    private int incrementId = 1;
    private String descricao;
    private String data;
    private String hour;
    private List<Publicacao> publicacao = new ArrayList<Publicacao>();
    private int qtd_interesses;
    private Usuario usuario;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getQtd_interesses() {
        return qtd_interesses;
    }

    public void setQtd_interesses(int qtd_interesses) {
        this.qtd_interesses = qtd_interesses;
    }

    public String cadastrarPublicacao(String descricao, String data, String hour, int qtdInteresses, Usuario usuario) {
        Publicacao novaPublicacao = new Publicacao();
        novaPublicacao.setId(this.incrementId);
        novaPublicacao.setDescricao(descricao);
        novaPublicacao.setData(data);
        novaPublicacao.setHour(hour);
        novaPublicacao.setQtd_interesses(qtdInteresses);
        novaPublicacao.setUsuario(usuario);
        if (!novaPublicacao.getDescricao().isEmpty()
                && !novaPublicacao.getData().toString().isEmpty()
                && !novaPublicacao.getHour().toString().isEmpty()
                && !novaPublicacao.getUsuario().toString().isEmpty()) {
            this.publicacao.add(novaPublicacao);
            this.incrementId++;
            return ("Publicacao gerada com sucesso");
        }
        return ("Erro ao gerar publicacao");
    }

    public List<Publicacao> verPublicacoes(Usuario usuario) {
        int i;
        List<Publicacao> publicacaoUsuario = new ArrayList<Publicacao>();
        for (i = 0; i < this.publicacao.size(); i++) {
            if (this.publicacao.get(i).getUsuario().getId() == usuario.getId()) {
                publicacaoUsuario.add(publicacao.get(i));
            }
        }
        return publicacaoUsuario;
    }

    public String removerPublicacao(int id, int userId) {
        int i;
        if (userId == 1) {
            for (i = 0; i < this.publicacao.size(); i++) {
                if (this.publicacao.get(i).getId() == id) {
                    this.publicacao.remove(i);
                    return ("Publicacao removida com sucesso");
                }
            }
        } else {
            for (i = 0; i < this.publicacao.size(); i++) {
                if (this.publicacao.get(i).getId() == id) {
                    if (this.publicacao.get(i).usuario.getId() == userId) {
                        this.publicacao.remove(i);
                        return ("Publicacao removida com sucesso");
                    } else {
                        return ("Voce não tem Permissão para remover essa publicacao");
                    }
                }
            }
        }
        return ("Voce não tem Permissão para remover essa publicacao");
    }

    public String EditarPublicacao(String descricao, String data, String hour, int qtdInteresses, Usuario usuario, int idPublicacao) {

        for (int i = 0; i < this.publicacao.size(); i++) {
            if (this.publicacao.get(i).getId() == idPublicacao) {
                if ((usuario.getId() == this.publicacao.get(i).usuario.getId()) || usuario.getId() == 1) {
                    this.publicacao.get(i).setDescricao(descricao);
                    this.publicacao.get(i).setData(data);
                    this.publicacao.get(i).setHour(hour);
                    this.publicacao.get(i).setQtd_interesses(qtdInteresses);
                    return ("Publicacao alterada com sucesso");
                } else {
                    return ("voce não tem autorização para editar essa publicacao");
                }
            }
        }
        return ("publicacao não encontrada");
    }
}
