package com.customer.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.account.publisher.AccountPublish;
import com.account.publisher.AccountPublishImpl;
import com.artist.publisher.ArtistPublish;
import com.artist.publisher.ArtistPublishImpl;
import com.delivery.publisher.DeliveryPublish;
import com.delivery.publisher.DeliveryPublishImpl;
import com.painting.publisher.PaintingPublish;
import com.painting.publisher.PaintingPublishImpl;

public class CustomerActivator implements BundleActivator {

	ServiceRegistration<?> publishCustomerRegistration;
	
	ServiceReference<?> artistServiceReference;
	ServiceReference<?> deliveryServiceReference;
	ServiceReference<?> paintingServiceReference;
	ServiceReference<?> accountServiceReference;
	
	ServiceReference<?> serviceReference;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Customer Subscriber Started !");
			
		artistServiceReference = context.getServiceReference(ArtistPublish.class.getName());
		ArtistPublish artistPublish = (ArtistPublishImpl) context.getService(artistServiceReference);
		
		deliveryServiceReference = context.getServiceReference(DeliveryPublish.class.getName());
		DeliveryPublish deliveryPublish = (DeliveryPublishImpl) context.getService(deliveryServiceReference);
		
		paintingServiceReference = context.getServiceReference(PaintingPublish.class.getName());
		PaintingPublish paintingPublish = (PaintingPublishImpl) context.getService(paintingServiceReference);
	
		accountServiceReference = context.getServiceReference(AccountPublish.class.getName());
		AccountPublish accountPublish = (AccountPublishImpl) context.getService(accountServiceReference);
		
		CustomerConsume customerConsume = new CustomerConsumeImpl(artistPublish, deliveryPublish, paintingPublish, accountPublish);
		customerConsume.init();
		stop(context);
		
	} 

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Customer Subscriber Stopped !");
		
		//publishCustomerRegistration.unregister();
		
		context.ungetService(serviceReference);
	
		context.ungetService(artistServiceReference);
		context.ungetService(deliveryServiceReference);
		context.ungetService(paintingServiceReference);
		context.ungetService(accountServiceReference);
		
	}

}
