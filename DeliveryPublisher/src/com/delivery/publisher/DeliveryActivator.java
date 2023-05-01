package com.delivery.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.delivery.publisher.DeliveryPublish;
import com.delivery.publisher.DeliveryPublishImpl;
import com.database.service.DeliveryDao;
import com.database.service.DeliveryDaoImpl;

public class DeliveryActivator implements BundleActivator {

	ServiceRegistration<?> publishDeliveryRegistration;
	ServiceReference<?> serviceReference;

	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(DeliveryDao.class.getName());
		DeliveryDao deliveryDao = (DeliveryDaoImpl) context.getService(serviceReference);
		
		System.out.println("Delivery Publisher Started !");
		
		DeliveryPublish publisherService = new DeliveryPublishImpl(deliveryDao);
		publishDeliveryRegistration = context.registerService(DeliveryPublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Delivery Publisher Stopped !");
		
		publishDeliveryRegistration.unregister();
		context.ungetService(serviceReference);
		
	}

}
