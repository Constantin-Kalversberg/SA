# JSF

Preprost primer aplikacije z ogrodjem JSF.

V web.xml je potrebno registrirati krmilnik (javax.faces.webapp.FacesServlet), nato preprosto uporabljamo gradnike in pi�emo upravljana zrna.

Aplikacija omogo�a vpis �tevil in njihovo ra�unanje, vodi tudi zgodovino ra�unov. Upravljano zrno, vezano na sejo uporabnika, je popolnoma neodvisno od prikaza.

Prikaz se ve�e na upravljano zrno in povezuje gradnike z atributi in metodami zrna.