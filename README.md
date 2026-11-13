# ProfilApp – Spring Boot Beispielanwendung

Eine kleine Beispielanwendung zur Demonstration einer sauberen Schichtenarchitektur mit Spring Boot.
Die Anwendung ermöglicht das Anzeigen und Bearbeiten eines Benutzerprofils.

##  Technologien
*   **Java** (Version 17 oder höher)
*   **Spring Boot** (Web, Validation)
*   **Gradle** (Build-Tool)
*   **Thymeleaf** (Template Engine)
*   **JUnit 5 & Mockito** (Testing)

##  Architektur
Das Projekt folgt einer klassischen 3-Schichten-Architektur:
*   **Web (`ProfilWebUI`)**: Der Controller, der HTTP-Anfragen verarbeitet und das Model befüllt.
*   **Logic (`ProfilEditor`)**: Die Service-Schicht, die die fachliche Logik (den Anwendungsfall) implementiert.
*   **Persistence (`Profile`)**: Die Repository-Schicht, die für das Laden und Speichern der Daten zuständig ist (aktuell als In-Memory-Lösung mit einer HashMap).
*   **Domain (`Profil`)**: Das Aggregate Root, das die Daten und das Verhalten des Profils kapselt.

##  Starten der Anwendung
1. Klone das Repository.
2. Öffne das Projekt in IntelliJ IDEA (oder einer anderen IDE).
3. Führe die Anwendung über die Klasse `ProfilappApplication` aus.
4. Öffne den Browser und rufe folgende URL auf: `http://localhost:8080/profil`

##  Tests ausführen
Die Anwendung enthält Unit-Tests (z.B. für den `ProfilEditor` und das `ProfilForm`) sowie Web-Tests (`@WebMvcTest` für den Controller).
Um die Tests auszuführen, nutze folgenden Befehl im Terminal:
```bash
./gradlew test