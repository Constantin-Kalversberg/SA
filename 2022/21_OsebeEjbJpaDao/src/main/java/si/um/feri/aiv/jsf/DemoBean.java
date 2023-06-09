package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.logging.Logger;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.ejb.Demo;
import si.um.feri.aiv.ejb.Osebe;
import si.um.feri.aiv.vao.Oseba;

@Named("demo")
@SessionScoped
public class DemoBean implements Serializable {

	private static final long serialVersionUID = -8979220536758073133L;

	Logger log=Logger.getLogger(DemoBean.class.toString());

	@EJB
	private Osebe ejb;
	
	@EJB
	private Demo demoEjb;

	private Oseba novaOseba=new Oseba();

	private Oseba izbranaOseba=new Oseba();
	
	private String izbranEmail;
	
	public void nekaj() {
		demoEjb.narediNekaj();
	}
	
	public void setIzbranEmail(String email) {
		log.info("JSF BEAN: setIzbranEmail");
		izbranEmail=email;
		try {
			izbranaOseba=ejb.najdi(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getIzbranEmail() {
		return izbranEmail;
	}

	public void dodajOsebo() {
		log.info("JSF BEAN: dodajOsebo");
		try {
			ejb.shrani(novaOseba);
			novaOseba=new Oseba();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Oseba getNovaOseba() {
		return novaOseba;
	}
	
	public void setNovaOseba(Oseba novaOseba) {
		this.novaOseba = novaOseba;
	}

	public Oseba getIzbranaOseba() {
		return izbranaOseba;
	}

	public void setIzbranaOseba(Oseba izbranaOseba) {
		this.izbranaOseba = izbranaOseba;
	}

}
