package br.eti.nsouza.controle;

import br.eti.nsouza.entidades.Solicitacao;
import br.eti.nsouza.servicos.ServicoSolicitacao;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
public class ControleSolicitacao {
    @Autowired
    private ServicoSolicitacao servicoSolicitacao;

    /**
     * Traz unica solicitacao
     * @param idsolicitacao
     * @return
     */
    @ApiOperation (value = "Realiza a busca da solicitacao pelo id da mesma.")
    @CrossOrigin
    @GetMapping (path = { "/solicitacao/unica/{idsolicitacao}" })
    public Solicitacao find2(@PathVariable ("idsolicitacao") int idsolicitacao) {
        Solicitacao solicitacao = servicoSolicitacao.findById(idsolicitacao);
        return solicitacao;
    }

    /**
     * Traz todas as solicitacoes
     * @return
     */
    @ApiOperation(value = "Realiza a busca de todas as solicitações muito cuidado !!! " +
            "pode honerar o banco de dados")
    @CrossOrigin
    @GetMapping ("/solicitacao/todas")
    public List<Solicitacao> findAllSoli() {
        List<Solicitacao> soli = servicoSolicitacao.findAll();
        return soli;
    }

}
