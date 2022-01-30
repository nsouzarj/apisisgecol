package br.eti.nsouza.controle;

import br.eti.nsouza.entidades.Comarca;
import br.eti.nsouza.servicos.ServicoComarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
public class ControleComarca {
    @Autowired
    private ServicoComarca servicoComarca;

    /**
     * Pega todas as comarcas
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/comarca")
    @ResponseBody
    List<Comarca> findAll2() {
        List<Comarca> com = servicoComarca.findAll();
        return com;
    }

    /**
     * Busca unica comarca
     * @param idcomarca
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping (path = { "/comarca/{idcomarca}" })
    public Comarca buscaunicacomarca(@PathVariable ("idcomarca") int idcomarca) {
        Comarca com = servicoComarca.findOne(idcomarca);
        return com;
    }

    /**
     * Busca por estado através da silgla
     * @param silga
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = { "/comarca/porestado/{iduf}" })
    public List<Comarca> buscaunicaestado(@PathVariable("iduf") int iduf) {
        List<Comarca> com = servicoComarca.buscaEstado(iduf);
        return com;
    }

}
