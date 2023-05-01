package com.painting.publisher;

import com.database.service.PaintingDao;
import com.database.service.PaintingDaoImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class PaintingActivator implements BundleActivator {
	
	ServiceReference<?> serviceReference;
	
	ServiceRegistration<?> publishPaintingRegistration; 

	public void start(BundleContext context) throws Exception {
			
			System.out.println("Painting Service Started !");
			
			serviceReference = context.getServiceReference(PaintingDao.class.getName());
			PaintingDao paintingDao = (PaintingDaoImpl) context.getService(serviceReference);
			
			PaintingPublish publishPainting1 = new PaintingPublishImpl(paintingDao);
			publishPaintingRegistration = context.registerService(PaintingPublish.class.getName(), publishPainting1, null);
		
	}

	public void stop(BundleContext context) throws Exception {
			
			System.out.println("Painting Service Stopped !");
			
			publishPaintingRegistration.unregister();
			
	}

}
