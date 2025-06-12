# User Stories für die ToDo-App

---
name: Persistente Datenspeicherung
about: Dauerhafte Speicherung von Aufgaben
title: "[User Story] Persistente Datenspeicherung" 
labels: user-story, enhancement, database
assignees: ''
---

### 👨 Rolle
*Als* Benutzer

### 🎯 Ziel / Wunsch
*möchte ich*, dass meine Aufgaben zwischen Sitzungen erhalten bleiben

### 💡 Nutzen
*damit* ich meine Daten nicht verliere, wenn der Server neu gestartet wird

---

### ✅ Teilaufgaben
- [ ] Datenbankanbindung implementieren
- [ ] Entity-Klassen für persistente Speicherung anpassen
- [ ] Repository-Schnittstellen erstellen
- [ ] Service-Layer für Datenbankzugriff entwickeln
- [ ] Error-Handling für Datenbankfehler einrichten

---

### 🔍 Akzeptanzkriterien
- Alle erstellten Aufgaben werden in einer MySQL-Datenbank gespeichert
- Nach einem Neustart des Servers werden alle zuvor erstellten Aufgaben wieder angezeigt
- Änderungen an Aufgaben (z.B. Markierung als erledigt) bleiben auch nach einem Neustart bestehen
- Die Datenbank ist vor Datenverlust geschützt und wird regelmäßig gesichert
- Bei Problemen mit der Datenbankverbindung erhält der Benutzer eine aussagekräftige Fehlermeldung

---
name: Fristfunktion
about: Hinzufügen von Fristen zu Aufgaben
title: "[User Story] Aufgaben mit Fristen versehen" 
labels: user-story, enhancement, deadline
assignees: ''
---

### 👨 Rolle
*Als* Benutzer

### 🎯 Ziel / Wunsch
*möchte ich* Fristen für meine Aufgaben hinzufügen können

### 💡 Nutzen
*damit* ich meine Arbeit besser priorisieren kann

---

### ✅ Teilaufgaben
- [ ] Datenmodell um Fristfeld erweitern
- [ ] Datepicker-Komponente ins Frontend einbinden
- [ ] Sortierung nach Datum implementieren
- [ ] Visuelle Hervorhebung von überfälligen/baldigen Aufgaben umsetzen
- [ ] API-Endpunkte für Fristoperationen anpassen

---

### 🔍 Akzeptanzkriterien
- Bei der Erstellung einer Aufgabe kann ein Fälligkeitsdatum über einen Datepicker ausgewählt werden
- Das Fälligkeitsdatum wird zusammen mit der Aufgabenbeschreibung angezeigt
- Aufgaben mit überfälligen Fristen werden visuell hervorgehoben (z.B. in rot)
- Aufgaben mit baldigen Fristen (innerhalb der nächsten 2 Tage) werden anders hervorgehoben (z.B. in gelb)
- Der Benutzer kann seine Aufgaben nach Fälligkeitsdatum sortieren (aufsteigend/absteigend)
- Die Fristen werden im ISO-Format YYYY-MM-DD gespeichert und angezeigt

---
name: Statussystem
about: Statussystem statt Löschung von Aufgaben
title: "[User Story] Statussystem statt Löschung" 
labels: user-story, enhancement, status
assignees: ''
---

### 👨 Rolle
*Als* Benutzer

### 🎯 Ziel / Wunsch
*möchte ich* Aufgaben als "erledigt" markieren können anstatt sie zu löschen

### 💡 Nutzen
*damit* ich meine abgeschlossenen Arbeiten verfolgen kann

---

### ✅ Teilaufgaben
- [ ] Statusfeld im Datenmodell ergänzen
- [ ] Status-Toggle-Buttons im UI implementieren
- [ ] Filterlogik für verschiedene Status entwickeln
- [ ] Visuelle Anzeige für unterschiedliche Status umsetzen
- [ ] Statusstatistiken für Dashboard implementieren
- [ ] Ein-/Ausblenden-Funktion für erledigte Aufgaben ergänzen

---

### 🔍 Akzeptanzkriterien
- Aufgaben haben einen Status (offen, in Bearbeitung, erledigt)
- Der Status kann durch Klicken auf entsprechende Buttons geändert werden
- Erledigte Aufgaben werden visuell anders dargestellt (z.B. durchgestrichen, verblasst)
- Der Benutzer kann Filter anwenden, um nur Aufgaben mit bestimmtem Status anzuzeigen
- Es gibt eine Übersicht, wie viele Aufgaben sich in welchem Status befinden
- Der Benutzer kann erledigte Aufgaben optional ausblenden/einblenden

---
name: Prioritätssystem
about: Einführung von Prioritätsstufen
title: "[User Story] Prioritätssystem für Aufgaben" 
labels: user-story, enhancement, priority
assignees: ''
---

### 👨 Rolle
*Als* Benutzer

### 🎯 Ziel / Wunsch
*möchte ich* Prioritätsstufen für meine Aufgaben festlegen können

### 💡 Nutzen
*damit* ich mich auf das Wichtigste konzentrieren kann

---

### ✅ Teilaufgaben
- [ ] Prioritätsfeld zum Datenmodell hinzufügen
- [ ] Prioritätsauswahl in der UI implementieren
- [ ] Visuelle Kennzeichnung von Prioritätsstufen entwickeln
- [ ] Sortier- und Filterfunktion nach Priorität einbauen
- [ ] Standardpriorität für neue Aufgaben festlegen
- [ ] Nachträgliche Änderungsfunktion für Prioritäten umsetzen

---

### 🔍 Akzeptanzkriterien
- Bei der Erstellung einer Aufgabe kann eine Priorität ausgewählt werden (hoch, mittel, niedrig)
- Die Priorität wird visuell angezeigt (z.B. durch Farben oder Symbole)
- Der Benutzer kann seine Aufgaben nach Priorität sortieren
- Die Filterung nach Priorität ist möglich
- Die Standardpriorität für neue Aufgaben ist "mittel"
- Die Priorität einer bestehenden Aufgabe kann nachträglich geändert werden

---
name: Kategoriesystem
about: Kategorisierung von Aufgaben
title: "[User Story] Kategoriesystem für Aufgaben" 
labels: user-story, enhancement, organization
assignees: ''
---

### 👨 Rolle
*Als* Benutzer

### 🎯 Ziel / Wunsch
*möchte ich* meine Aufgaben kategorisieren können

### 💡 Nutzen
*damit* ich sie besser organisieren kann

---

### ✅ Teilaufgaben
- [ ] Kategorie-Entität und Datenmodell erstellen
- [ ] Many-to-many Relation zwischen Tasks und Kategorien implementieren
- [ ] UI für Kategorieverwaltung entwickeln
- [ ] Farbliche Darstellung von Kategorien umsetzen
- [ ] Filter- und Sortierfunktion für Kategorien hinzufügen
- [ ] Verwaltungssystem für Kategorien erstellen

---

### 🔍 Akzeptanzkriterien
- Bei der Erstellung einer Aufgabe kann eine Kategorie ausgewählt oder neu erstellt werden
- Kategorien werden farblich unterschiedlich dargestellt
- Der Benutzer kann nach Kategorien filtern
- Die Anzahl der Aufgaben pro Kategorie wird angezeigt
- Kategorien können bearbeitet und gelöscht werden (sofern keine Aufgaben mehr in dieser Kategorie sind)
- Eine Aufgabe kann mehreren Kategorien zugeordnet werden
