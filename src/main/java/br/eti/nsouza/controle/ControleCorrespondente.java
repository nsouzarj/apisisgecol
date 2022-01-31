package br.eti.nsouza.controle;

import br.eti.nsouza.entidades.Correspondente;
import br.eti.nsouza.servicos.ServicoCorrespondente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping(value = "/api")
public class ControleCorrespondente {
    @Autowired
    private ServicoCorrespondente servicoCorrespondente;

    /**
     * Traz todos os colaboradores
     *
     * @return
     */
    @CrossOrigin
    @GetMapping (path = "/colaborador")
    @ResponseBody
    List<Correspondente> findAllCor() {
        List<Correspondente> com = servicoCorrespondente.findAll();
        return com;
    }

    /**
     * TRaz unico correspondente
     *
     * @param idcorrespondente
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = "/colaborador/{id}")
    public Correspondente findcor(@PathVariable ("id") int idcorrespondente) {
        Correspondente cor = servicoCorrespondente.findOne(idcorrespondente);
        return cor;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(path = "/colaborador/}")
    public  Correspondente salvaCarrespodente(@PathVariable Correspondente corr)  {
        Correspondente correspondente = new Correspondente();
        try {
            correspondente= servicoCorrespondente.save(corr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return correspondente;
    }


}
