
package com.mycompany.petinder;

/**
 *
 * @author choviski
 */
public class TipoUsuario {
    private String nome;
    private String[] permissoes;

    public void setPermissoes(String[] permissoes) {
        this.permissoes = permissoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String[] getPermissoes() {
        return this.permissoes;
    }
      
}
