import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserAuthenticationService {

    private final AuthenticationManager authenticationManager;

    public UserAuthenticationService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void authenticate(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
