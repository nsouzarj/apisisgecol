package br.eti.nsouza.controle;
import br.eti.nsouza.entidades.Comarca;
import br.eti.nsouza.entidades.ComarcaPossui;
import br.eti.nsouza.servicos.ServicoComarca;
import br.eti.nsouza.servicos.ServicoComarcaPossui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping(value = "/api")
public class ControleComarca {
    @Autowired
    private ServicoComarca servicoComarca;
    @Autowired
    private ServicoComarcaPossui servicoComarcaPossui;

    /**
     * Pega todas as comarcas
     * @return
     */
    @CrossOrigin(value = "*",maxAge = 5000)
    @GetMapping(path = "/comarca")
    @ResponseBody
    List<Comarca> findAll() {
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
     * @param iduf
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = { "/comarca/porestado/{iduf}" })
    public List<Comarca> buscaunicaestado(@PathVariable("iduf") int iduf) {
        List<Comarca> com = servicoComarca.buscaEstado(iduf);
        return com;
    }

    /**
     * Retorna as comarcas do correspondente
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = { "/comarcapossui/{idcorrespondente}" })
    public List<ComarcaPossui> findComPossui(@PathVariable("idcorrespondente") int idcorrespondente) {
        List<ComarcaPossui> compossui = servicoComarcaPossui.findByid(idcorrespondente);
        return compossui;
    }

}
