package br.com.fernantech.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.fernantech.brewer.service.CadastroCervejaService;
import br.com.fernantech.brewer.storage.FotoStorage;

@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class, FotoStorage.class})
public class ServiceConfig {


	
}
