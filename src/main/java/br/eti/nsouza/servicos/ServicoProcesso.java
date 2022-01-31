package br.eti.nsouza.servicos;
import br.eti.nsouza.entidades.Processo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

@Service
public class ServicoProcesso {
    @Autowired
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    public List<Processo> findAll() {
        List<Processo> processos =entityManager.createQuery("from Processo order by idprocesso asc ").setFirstResult(0).setMaxResults(300).getResultList();
        return processos;
    }
    //Salva o processo na bse
    public void salvaProcesso(Processo processo) throws SQLException {
        entityManager.persist(processo);
    }

    //Traz o unico processo na base
    public Processo trazUnicoProcesso( Integer idproceso) throws  SQLException {
      Processo processo= entityManager.find(Processo.class, idproceso);
      return processo;
    }
}
