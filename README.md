# Patient Management Software
## Descrierea temei
Aplicatia doreste a rezolva problema gestionarii pacientilor si examinarilor acestora dintr-o clinica
medicala. Pentru dezvoltarea aplicatiei se va folosi limbajul de programare Java si framework-ul Spring.
Datele vor fi stocate intr-o baza de date.
## Utilizatorii aplicatiei
Aplicatia va avea 3 clase de utilizatori:  
- Pacient: poate vedea propriile examinari si rezultate
- Doctor: adauga un nou pacient in baza de date (daca nu exista), creeaza examinari pentru pacienti
- Admin: poate adauga noi doctori
## Implementare
Pentru o mai buna intelegere a aplicatiei aceasta a fost impartita in pachete.  
Pachetul "entity" contine clasele ce descriu campurile tabelelor din baza de date.  
Pachetul "repository" contine interfetele pe care clasele de tip controller le vor implementa.  
Pachetul "controller" contine clasele ce realizeaza conexiunea dintre datele din aplicatie si cele din
baza de date.  
Pachetul "observer" contine clasele si interfetele necesare pentru design pattern-ul Observer ce notifica
pacientul in momentul in care examinarea sa a primit un rezultat.  
Pentru testarea functionalitatilor aplicatiei am folosit Mockito.
## Diagrame
### Diagrama de clase
![image](Class%20diagram.png)
### Diagrama de secventa
![image](Sequence%20diagram.png)