# 📚 Aplicație de Gestiune Bibliotecă

## 📖 Descriere

Această aplicație permite gestionarea unei biblioteci, permițând adăugarea și evidența cărților, cititorilor, bibliotecarilor și a împrumuturilor, oferind în același timp funcții de căutare, raportare și organizare, folosind moștenire unde e cazul, colecții de date organizate și o clasă service pentru logica principală.

---

## 📦 Lista de obiecte utilizate

Aplicația folosește următoarele 8 tipuri de obiecte:

- **Autor** — reprezintă un scriitor al cărților.
- **Carte** — reprezintă o carte disponibilă în bibliotecă.
- **Cititor** — reprezintă o persoană care poate împrumuta cărți.
- **Bibliotecar** — angajat responsabil de gestionarea cărților și a cititorilor.
- **Editura** — entitatea care publică o carte.
- **Sectiune** — zona tematică sau de organizare a cărților în bibliotecă.
- **Imprumut** — înregistrarea unui împrumut de carte de către un cititor.
- **Persoana** — clasa de bază pentru Cititor și Bibliotecar (prin moștenire).

---

## 🛠️ Lista de acțiuni disponibile

1. Adaugă o carte în bibliotecă  
2. Înscrie un cititor nou  
3. Înregistrează un bibliotecar  
4. Împrumută o carte  
5. Returnează o carte  
6. Afișează toate cărțile disponibile în stoc  
7. Afișează cărțile unui anumit autor  
8. Afișează toate împrumuturile unui cititor  
9. Găsește cartea cu cele mai multe exemplare disponibile  
10. Caută o carte după titlu (căutare parțială)  
11. Afișează top 3 cei mai activi cititori (cu cele mai multe împrumuturi)  
12. Afișează toate cărțile dintr-o anumită secțiune, ordonate alfabetic  

---

## 📂 Colectii de date folosite

Datele sunt gestionate în colecții:

- `carti` ( TreeSet cu titlurile sortate alfabetic )
- `lista_autori`   
- `lista_cititori`  
- `lista_bibliotecari`  
- `lista_edituri`  
- `lista_sectiuni`  
- `imprumuturi` ( HashMap cu cititor-lista de imprumuturi )  

---

## 🏛️ Moștenire

Structura claselor folosește moștenire pentru a gestiona eficient informațiile comune:

- Clasa **Persoana** este clasa de bază, conținând date comune precum nume, prenume, CNP.  
- **Cititor** și **Bibliotecar** moștenesc clasa Persoana și adaugă atribute și metode specifice:  
  - Cititor are, în plus, un ID de cititor și o listă de împrumuturi.  
  - Bibliotecar are un cod de angajat și funcții administrative.  

---

## 🛎️ Clasa Service

Clasa `ServiceBiblioteca` gestionează logica principală a aplicației:

- Conține metode pentru fiecare acțiune disponibilă în aplicație.  
- Interacționează cu colecțiile de date pentru a adăuga, căuta, actualiza sau șterge înregistrări.  
- Realizează căutări, sortări, topuri și afișări personalizate pe baza criteriilor date.  
- Asigură separarea logicii de business de interfața utilizatorului.  

---

