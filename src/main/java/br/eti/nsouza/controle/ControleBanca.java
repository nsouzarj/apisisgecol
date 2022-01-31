package br.eti.nsouza.controle;

import br.eti.nsouza.entidades.BancaProcesso;
import br.eti.nsouza.servicos.ServicoBanca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.sql.SQLException;
import java.util.List;

@Controller
@CrossOrigin ("*")
@RequestMapping(value = "/api")
public class ControleBanca {
    @Autowired
    ServicoBanca servicoBanca;
    /**
     * Busca todas as bancas
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/bancas")
    @ResponseBody
    public List<BancaProcesso> findAllBanca() {
        List<BancaProcesso> com = servicoBanca.findAll();
        return com;
    }


    @CrossOrigin(origins = "*")
    @GetMapping(value = "/bancas/{idbanca}")
    @ResponseBody
    BancaProcesso findOne(@PathVariable Integer idbanca){
        return servicoBanca.findOne(idbanca);
    }

    @CrossOrigin(origins = "*")
    @PostMapping (value = "/banca/salvar")
    @ResponseBody
    public void save(@PathVariable BancaProcesso bancaProcesso){
        try {
            servicoBanca.save(bancaProcesso);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @GetMapping(value = "/banca/excluir/{idbanca}")
    public String delete(@PathVariable(required = true) Integer idbanca){
        try {
            servicoBanca.delete(idbanca);
            return "Banca excluida com sucesso";
        } catch (Exception e) {
           return "Erro ao excluir a banca"+e.getMessage();
        }
    }

}
