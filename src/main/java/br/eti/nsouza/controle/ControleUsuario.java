package br.eti.nsouza.controle;
import java.security.Principal;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.eti.nsouza.sisgecol.User;

@RestController
@CrossOrigin
public class ControleUsuario {
	 @GetMapping(value="/login", produces= MediaType.APPLICATION_JSON_VALUE)
	    public boolean login(User user) {
		    System.out.print(user.getUsername());
		    System.out.print(user.getPassword());
	        return   user.getUsername().equals("username") && user.getPassword().equals("password");
	    }
	     
	 @GetMapping("/user")
	    public Principal user(HttpServletRequest request) {
	        String authToken = request.getHeader("Authorization")
	          .substring("Basic".length()).trim();
	        return () ->  new String(Base64.getDecoder()
	          .decode(authToken)).split(":")[0];
	    }

	 @GetMapping("/user/me")
	     public Principal user(Principal principal) {
	         return principal;
	     }

}
