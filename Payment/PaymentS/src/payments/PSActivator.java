package payments;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import payment.IPayment;

public class PSActivator implements BundleActivator {

	Scanner sc = new Scanner(System.in);
	ServiceReference servicePayment; // for Payment Registration


	String continuation = "y"; // for option
	String reg = "";

	@Override
	public void start(BundleContext context) throws Exception {
		//Payment Service
		System.out.println("Start Payment Registration");
		servicePayment = context.getServiceReference(IPayment.class.getName());
		IPayment servicePublishPayment = (IPayment) context.getService(servicePayment);
		
		

		System.out.println("Registration Successfull!! Thank You ");

		while (continuation.equalsIgnoreCase("y")) {
			System.out.println("What Service you want");
			System.out.println("1 - Payment Registration ");
			String option = sc.nextLine();

			if (option.equals("1")) {

				//check if Payment Registration has done before
				if (servicePublishPayment.detailsPayment().equals("0")) {
					System.out.println(servicePublishPayment.payment()); // Payment Registration
				} else {
					System.out.println("You already filled Payment Registration Form!");

				} // end Payment Registration perform check

			}
		}
			
			
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
