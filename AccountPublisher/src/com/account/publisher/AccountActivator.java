package com.account.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.database.service.AccountDao;
import com.database.service.AccountDaoImpl;

public class AccountActivator implements BundleActivator {
	
	ServiceRegistration<?> publishAccountRegistration;
	ServiceReference<?> serviceReference;

	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(AccountDao.class.getName());
		AccountDao accountDao = (AccountDaoImpl) context.getService(serviceReference);
		
		System.out.println("Account Publisher Started !");
		
		AccountPublish publisherService = new AccountPublishImpl(accountDao);
		publishAccountRegistration = context.registerService(AccountPublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Account Publisher Stopped !");
		
		publishAccountRegistration.unregister();
		context.ungetService(serviceReference);
		
	}
	
}
