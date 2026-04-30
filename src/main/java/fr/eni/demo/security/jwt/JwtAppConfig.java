package fr.eni.demo.security.jwt;
import fr.eni.demo.dal.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.*;

@Configuration
public class JwtAppConfig {

    /**
     * Authentification de l'utilisateur depuis la base de données
     */
    @Autowired
    private FormateurRepository.UserInfoRepository userInfoRepository;
    @Bean
    UserDetailsService userDetailsService() {
        return username -> userInfoRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Implémente comment récupérer un UserDetails
     */
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
        return authProvider;
    }

    /**
     * DaoAuthenticationProvider recherche le UserDetails à partir du UserDetailsService
     */
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}