# SuperDuperMarkt

## Beschreibung
SuperDuperMarkt ist eine Spring Boot Konsolenanwendung, die simuliert, wie sich die Qualität und der Preis verschiedener Produkte im Laufe der Zeit verändern.

## Ziel
Bewerberaufgabe

## Ausführung
- Projekt öffnen
- Warten, bis Maven alle Abhängigkeiten geladen hat (evtl. Rechtsklick auf pom.xml und Add as Maven Project
- Datei SuperDuperMarktApplication.java öffnen
- Auf den grünen Run-Pfeil neben der main()-Methode klicken (evtl. muss eine JDK mit Version 17 gesetzt werden)
- In der Konsole erscheinen nun die Simulationsergebnisse:
```
CSV-Datei erfolgreich geladen: 5 Produkte.

==== Tag 0 — 2025-10-31 ====
Emmentaler | Preis: 5.50€ | Qualität: 35 | Entfernen: NEIN
```

## Test
mvn test
