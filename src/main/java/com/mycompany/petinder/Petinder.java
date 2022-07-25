
package com.mycompany.petinder;

/**
 *
 * @author choviski
 */
public class Petinder {

    public static void main(String[] args) {
        System.out.println("Início dos testes");
        Teste t1 = new Teste();
        t1.testaUsuario();
        t1.testaPublicacao();
        t1.testaComentario();
        System.out.println("Fim dos testes");
    }
}
