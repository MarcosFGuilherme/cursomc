package com.educandoweb.cursomc.config;

public class SecurityConfig{
	
}
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
////	private static final String[] PUBLIC_MATCHERS = {
////			"/h2-console/**",
////			"/produtos/**",
////			"categorias/**"
////	};
////	
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.cors().and().csrf().disable();
////		http.authorizeRequests()
////		.antMatchers(PUBLIC_MATCHERS).permitAll()
////		.anyRequest().authenticated();
////		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////	}
////	
////	@Bean
////	CorsConfigurationSource corsConfigurationSource() {
////		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
////		return source;
////	}
//}
