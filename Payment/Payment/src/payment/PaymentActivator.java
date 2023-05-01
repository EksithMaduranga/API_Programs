package payment;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PaymentActivator implements BundleActivator {

ServiceRegistration publishRegister;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Payment Register Publisher Start");
		IPayment publishService = new PaymentImpl();
		publishRegister = context.registerService(IPayment.class.getName(), publishService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Payment Register Publisher stop");
		publishRegister.unregister();
	}

}
