package br.com.fernantech.brewer.repository.listener;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.fernantech.brewer.model.Cerveja;
import br.com.fernantech.brewer.storage.FotoStorage;
//Aula 28.5 a partir do 25 min
public class CervejaEntityListener {
	
	@Autowired
	private FotoStorage fotoStorage;

	@SuppressWarnings("static-access")
	@PostLoad
	public void postLoad(final Cerveja cerveja) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
		cerveja.setUrlFoto(fotoStorage.getUrl(cerveja.getFotoOuMock()));
		cerveja.setUrlThumbnailFoto(fotoStorage.getUrl(fotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOuMock()));
	}
}
