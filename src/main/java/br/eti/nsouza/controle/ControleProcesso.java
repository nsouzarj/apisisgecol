package br.eti.nsouza.controle;

import br.eti.nsouza.entidades.Processo;
import br.eti.nsouza.servicos.ServicoProcesso;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping(value = "/api")
public class ControleProcesso {
    @Autowired
    ServicoProcesso servicoProcesso;

    @CrossOrigin
    @GetMapping (path = "/processos")
    @ResponseBody
    List<Processo> todoOsProessos () {
        return servicoProcesso.findAll();
    }

    @ApiOperation(value = "Realiza o cadastro de processo")
    @PostMapping (path = "/processos")
    @ResponseBody
    void salvaProcesso (@RequestParam Processo processo) {
        try {
            servicoProcesso.salvaProcesso(processo);
        } catch (SQLException e) {
            System.out.print("Error ao salvar a solicitacao " + e.getMessage());
        }

    }

    @ApiOperation(value = "Busca unico  processo.")
    @GetMapping (path = "/processos/{idprocesspo}")
    @ResponseBody
    Processo unicoProcesso (@RequestParam Integer idprocesso) {
        Processo processo = new Processo();
        try {
            processo= servicoProcesso.trazUnicoProcesso(idprocesso);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processo;
    }
}
