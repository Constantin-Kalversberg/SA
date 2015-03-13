# Uporaba podatkovnega vira v DAO vzorcu - primer na WildFly 8.2

Primer povezovanja na podatkovne vire aplikacijskega stre�nika. V primeru uporabimo kar demo podatkovni vir na vgrajeni podatkovni bazi H2.

Iz upravljanega zrna se lahko pove�emo z uporabo oznake:

@Resource(lookup="java:jboss/datasources/ExampleDS")
DataSource baza;

Sicer pa je mo�na pridobitev podatkovnega vira tudi preko JNDI poizvedbe:

baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");