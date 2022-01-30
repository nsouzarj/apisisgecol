package br.eti.nsouza.controle;

import br.eti.nsouza.entidades.Correspondente;
import br.eti.nsouza.servicos.ServicoCorrespondente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
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

}