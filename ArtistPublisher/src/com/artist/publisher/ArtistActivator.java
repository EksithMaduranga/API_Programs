package com.artist.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.database.service.ArtistDao;
import com.database.service.ArtistDaoImpl;

public class ArtistActivator implements BundleActivator {
	
	ServiceRegistration<?> publishArtistRegistration;
	ServiceReference<?> serviceReference;

	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(ArtistDao.class.getName());
		ArtistDao artistDao = (ArtistDaoImpl) context.getService(serviceReference);
		
		System.out.println("Artist Publisher Started !");
		
		ArtistPublish publisherService = new ArtistPublishImpl(artistDao);
		publishArtistRegistration = context.registerService(ArtistPublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Artist Publisher Stopped !");
		
		publishArtistRegistration.unregister();
		context.ungetService(serviceReference);
		
	}
	
}
