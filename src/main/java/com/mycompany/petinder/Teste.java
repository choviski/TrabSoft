package com.mycompany.petinder;
import junit.framework.TestCase;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author choviski
 */
public class Teste extends TestCase {
    
    public void testaUsuario(){
        Usuario user1 = new Usuario();
        assertEquals("Usuario cadastrado com Sucesso", user1.cadastrarUsuario("Eric Silveira", "eric@gmail.com", "EricSilveira", "123")); 

        assertEquals("Erro ao cadastrar usuario, algum campo está nulo", user1.cadastrarUsuario("user2", "user2@gmail.com", "", "123"));
        
        assertEquals("email Enviado com sucesso", user1.recuperarSenha("eric@gmail.com"));
        assertEquals("erro ao enviar email", user1.recuperarSenha(""));
        
        assertEquals("usuario Removido com sucesso", user1.removeUsuario(1, 1));
        assertEquals("Voce não tem permissão para Remover esse usuario", user1.removeUsuario(2, 2));
        
        
    }
    
    public void testaPublicacao(){
        Usuario user1 = new Usuario();
        assertEquals("Usuario cadastrado com Sucesso", user1.cadastrarUsuario("Eric Silveira", "eric@gmail.com", "EricSilveira", "123")); 
        
        assertEquals("Usuario cadastrado com Sucesso", user1.cadastrarUsuario("Eric2 Silveira", "eric@gmail.com", "EricSilveira", "123")); 
        
       
        Publicacao pub = new Publicacao();
        assertEquals("Publicacao gerada com sucesso", pub.cadastrarPublicacao("teste", "10-10-2022", "03-10-00", 2, user1.usuarios.get(0)));
        assertEquals("Erro ao gerar publicacao", pub.cadastrarPublicacao("", "10-10-2022", "03-10-00", 2, user1));
        
        assertEquals("Publicacao gerada com sucesso", pub.cadastrarPublicacao("teste", "10-10-2022", "03-10-00", 2, user1.usuarios.get(1)));
       
        assertEquals("Publicacao gerada com sucesso", pub.cadastrarPublicacao("teste", "10-10-2022", "03-10-00", 2, user1.usuarios.get(0)));
        
        assertEquals("Voce não tem Permissão para remover essa publicacao", pub.removerPublicacao(1, 2));
        assertEquals("Publicacao removida com sucesso", pub.removerPublicacao(1, 1));
        assertEquals("Voce não tem Permissão para remover essa publicacao", pub.removerPublicacao(3, 2));
        
        
        assertEquals("Publicacao alterada com sucesso", pub.EditarPublicacao("descricao nova", "data nova", "hora nova", 0, user1.usuarios.get(0), 3));
        assertEquals("Publicacao alterada com sucesso", pub.EditarPublicacao("descricao nova", "data nova", "hora nova", 0, user1.usuarios.get(0), 2));
        assertEquals("voce não tem autorização para editar essa publicacao", pub.EditarPublicacao("descricao nova", "data nova", "hora nova", 0, user1.usuarios.get(1), 3));
        assertEquals("publicacao não encontrada", pub.EditarPublicacao("descricao nova", "data nova", "hora nova", 0, user1.usuarios.get(1), 20));
    }
    
    public void testaComentario(){
        Usuario user1 = new Usuario();
        assertEquals("Usuario cadastrado com Sucesso", user1.cadastrarUsuario("Eric Silveira", "eric@gmail.com", "EricSilveira", "123")); 
        
        assertEquals("Usuario cadastrado com Sucesso", user1.cadastrarUsuario("Eric2 Silveira", "eric@gmail.com", "EricSilveira", "123")); 
        
       
        Comentario com = new Comentario();
        assertEquals("Comentario gerado com sucesso", com.cadastrarComentario("teste", "10-10-2022", "03-10-00", user1.usuarios.get(0)));
        assertEquals("Erro ao gerar comentario", com.cadastrarComentario("", "10-10-2022", "03-10-00", user1));
        
        assertEquals("Comentario gerado com sucesso", com.cadastrarComentario("teste", "10-10-2022", "03-10-00", user1.usuarios.get(1)));
       
        assertEquals("Comentario gerado com sucesso", com.cadastrarComentario("teste", "10-10-2022", "03-10-00", user1.usuarios.get(0)));
        
        assertEquals("Voce não tem Permissão para remover esse comentario", com.removerComentario(1, 2));
        assertEquals("Comentario removido com sucesso", com.removerComentario(1, 1));
        assertEquals("Voce não tem Permissão para remover esse comentario", com.removerComentario(3, 2));
        
        
        assertEquals("Comentario alterado com sucesso", com.EditarComentario("descricao nova", "data nova", "hora nova", user1.usuarios.get(0), 3));
        assertEquals("Comentario alterado com sucesso", com.EditarComentario("descricao nova", "data nova", "hora nova", user1.usuarios.get(0), 2));
        assertEquals("voce não tem autorização para editar esse comentario", com.EditarComentario("descricao nova", "data nova", "hora nova", user1.usuarios.get(1), 3));
        assertEquals("comentario não encontrado", com.EditarComentario("descricao nova", "data nova", "hora nova", user1.usuarios.get(1), 20));
    }
}
