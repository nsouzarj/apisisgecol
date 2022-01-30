/**
 * Projeto de rest full para o sistema de colaboradores com 
 * intúito de aprender angular e boot spring
 * graças as aulas do Prefessor Tasso Beça que foram essencias 
 * para realicação desse projeto
 * 27/12/2018 
 */
/**
	 * Serviços dimoniveis no REST 
	 * @GetMapping(path = "/tipos")
	 * @GetMapping(path = { "/comarcapossui/{idcorrespondente}" })
       @GetMapping(path = { "/usuarios/{idusuario}" })
       @GetMapping(path = "/usuarios}")
       @GetMapping(path = "/colaborador/{id}")
       @GetMapping(path = "/colaborador")
       @GetMapping(path = "/bancas")
       @GetMapping(path = "/comarca")
       @GetMapping(path = { "/comarca/{idcomarca}" })
       @GetMapping(path = { "/comarca/porestado/{sigla}" })
       @RequestMapping("/solicitacao/todas")
       @GetMapping(path = { "/solicitacao/unica/idsolicitacao}" })
       @RequestMapping("/uf")
       @GetMapping(path = { "/uf/{iduf}" })
	 * 
	 */

package br.eti.nsouza.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import br.eti.nsouza.entidades.BancaProcesso;
import br.eti.nsouza.entidades.Comarca;
import br.eti.nsouza.entidades.ComarcaPossui;
import br.eti.nsouza.entidades.Correspondente;
import br.eti.nsouza.entidades.Solicitacao;
import br.eti.nsouza.entidades.StatusSolicitacao;
import br.eti.nsouza.entidades.TipoSolicitacao;
import br.eti.nsouza.entidades.Uf;
import br.eti.nsouza.entidades.Usuario;
import br.eti.nsouza.servicos.ServicoBanca;
import br.eti.nsouza.servicos.ServicoComarca;
import br.eti.nsouza.servicos.ServicoComarcaPossui;
import br.eti.nsouza.servicos.ServicoCorrespondente;
import br.eti.nsouza.servicos.ServicoLogin;
import br.eti.nsouza.servicos.ServicoSolicitacao;
import br.eti.nsouza.servicos.ServicoStatusSolicitacao;
import br.eti.nsouza.servicos.ServicoTipoSolicitacao;
import br.eti.nsouza.servicos.ServicoUf;
import br.eti.nsouza.servicos.ServicoUsuario;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControleGeral {

	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
				.allowCredentials(true).maxAge(3600);

	}


	@Autowired
	private ServicoUf servicoUf;

	@Autowired
	private ServicoBanca servicoBanca;

	@Autowired
	private ServicoUsuario servicoUsuario;
	@Autowired
	private ServicoComarcaPossui servicoComarcaPossui;
	@Autowired
	private ServicoTipoSolicitacao servicoTipoSolicitacao;
	@Autowired
	private ServicoStatusSolicitacao servicoStatusSolicitacao;
	@Autowired
	private ServicoLogin servicoLogin;

	@CrossOrigin
	@ResponseBody
	public String Busca() {
		return "<H2>SERVIDOR RESTFULL SIGECOL <H2>";
	}

	@CrossOrigin
	@RequestMapping("/erro")
	@ResponseBody
	public String Erro() {
		return "<H2>SENHA OU LOGIN ERRADO<H2>";
	}

	@CrossOrigin
	@RequestMapping(path = { "/usuariologin/{emailprincipal}/{senha}"})
	@ResponseBody
	public Usuario login(@PathVariable("emailprincipal") String emailprincipal, @PathVariable("senha") String senha ){
		Usuario usuario= servicoLogin.busca(emailprincipal,senha );
		return usuario;
 
    }
	


	/**
	 * Traz as uf
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("/uf")
	@ResponseBody
	public List<Uf> findAll() {
		List<Uf> teste = servicoUf.findAll();
		return teste;
	}

	/**
	 * Busca unico
	 * @param iduf
	 * @return
	 */
	@CrossOrigin
	@ResponseBody
	@GetMapping(path = { "/uf/{iduf}" })
	public Uf find1(@PathVariable("iduf") int iduf) {
		Uf uf = servicoUf.findOne(iduf);
		return uf;

	}



	/**
	 * Busca todas as bancas
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/bancas")
	@ResponseBody
	List<BancaProcesso> findAllBanca() {
		List<BancaProcesso> com = servicoBanca.findAll();
		return com;
	}


	/**
	 * Traz todos os usuarios
	 * @return
	 */
	@CrossOrigin
	@ResponseBody
	@GetMapping(path = "/usuarios")
	public List<Usuario> findAllusuarios() {
		List<Usuario> usu = servicoUsuario.findAll();
		return usu;
	}

	/**
	 * Traz unico unsuario
	 * 
	 * @param idusuario
	 * @return
	 */
	@CrossOrigin
	@ResponseBody
	@GetMapping(path = { "/usuarios/{idusuario}" })
	public Usuario findUnicoUsuario(@PathVariable("idusuario") int idusuario) {
		Usuario usuario = servicoUsuario.findOne(idusuario);
		return usuario;
	}



	/**
	 * Traz todos os colaboradores
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/tipos")
	@ResponseBody
	List<TipoSolicitacao> findAllTipo() {
		List<TipoSolicitacao> com = servicoTipoSolicitacao.findAll();
		return com;
	}

	/**
	 * Traz todos os colaboradores
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/status")
	@ResponseBody
	List<StatusSolicitacao> findStatusSoli() {
		List<StatusSolicitacao> solistatus = servicoStatusSolicitacao.findAll();
		return solistatus;
	}


}