package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.ejb.OsebaDao;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

@Named("demo")
@SessionScoped
public class OsebaJsfBean implements Serializable {

	private static final long serialVersionUID = -8979220536758073133L;

	Logger log=Logger.getLogger(OsebaJsfBean.class.toString());

	@EJB
	private OsebaDao dao;
	
	private Oseba izbranaOseba=new Oseba();
	
	private String izbranEmail;
	
	public List<Oseba> getVseOsebe() throws Exception {
		return dao.vrniVse();
	}
	
	public String shraniOsebo() throws Exception {
		dao.shrani(izbranaOseba);
		return "vse";
	}
	
	public void izbrisiOsebo(Oseba o) throws Exception {
		dao.izbrisi(o.getEmail());
	}

	public void dodajKontakt() throws Exception {
		dao.shraniKontakt(new Kontakt(), izbranaOseba.getEmail());
		izbranaOseba=dao.najdi(izbranaOseba.getEmail());
	}

	public void shraniKontakt(Kontakt k) throws Exception {
		k.setUrejanje(false);
		dao.spremeniKontakt(k);
		izbranaOseba=dao.najdi(izbranaOseba.getEmail());
	}
	
	public void izbrisiKontakt(Kontakt k) throws Exception {
		dao.izbrisiKontakt(k.getId(), izbranaOseba.getEmail());
		izbranaOseba=dao.najdi(izbranaOseba.getEmail());
	}
	
	public void urediKontakt(Kontakt k) throws Exception {
		k.setUrejanje(true);
		dao.spremeniKontakt(k);
		izbranaOseba=dao.najdi(izbranaOseba.getEmail());
	}
	
	public void setIzbranEmail(String email) throws Exception {
		izbranEmail=email;
		izbranaOseba=dao.najdi(email);
		if(izbranaOseba==null) izbranaOseba=new Oseba();
	}
	
	public String getIzbranEmail() {
		return izbranEmail;
	}

	public Oseba getIzbranaOseba() {
		return izbranaOseba;
	}

	public void setIzbranaOseba(Oseba izbranaOseba) {
		this.izbranaOseba = izbranaOseba;
	}
	
}
