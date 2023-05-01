package com.database.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DatabaseActivator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegistration;

	public void start(BundleContext context) {
		
		System.out.println("Database Service Started !");
		
		ArtistDao artistDao = new ArtistDaoImpl();
		AccountDao customerDao = new AccountDaoImpl();
		DeliveryDao deliveryDao = new DeliveryDaoImpl();
		PaintingDao paintingDao = new PaintingDaoImpl();
		
		publishServiceRegistration = context.registerService(ArtistDao.class.getName(), artistDao, null);
		publishServiceRegistration = context.registerService(AccountDao.class.getName(), customerDao, null);
		publishServiceRegistration = context.registerService(DeliveryDao.class.getName(), deliveryDao, null);
		publishServiceRegistration = context.registerService(PaintingDao.class.getName(), paintingDao, null);
		
	}

	public void stop(BundleContext bundleContext) {
		
		System.out.println("Database Service Stopped !");
		publishServiceRegistration.unregister();
		
	}

}
