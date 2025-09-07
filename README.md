SeleniumAutomationFramework

Framework de automatización Web UI con Java + Selenium 4 + Cucumber (JUnit) + Gradle.

Este README está ajustado a tu proyecto actual (runner JUnit, reportes en target/cucumber-reports, Gradle, WebDriverManager).

🎯 Objetivo

Base simple para pruebas UI con Page Object Model + escenarios BDD. Incluye hooks con screenshots en fallo y reporte HTML de Cucumber.

🎥 Evidencia / Reportes

HTML: target/cucumber-reports

(JSON, opcional): agrega "json:build/reports/cucumber.json" al plugin si querés reportes avanzados.

🚀 Stack

Java: 17+

Selenium: 4.x

Cucumber: 7.x (Runner JUnit)

Build: Gradle 8.x

Drivers: io.github.bonigarcia:webdrivermanager (automático)

📦 Estructura actual
src/test/java/
  pages/            # Page Objects (BasePage, PaginaPrincipal, ...)
  steps/            # Step Definitions
  runner/           # TestRunner (JUnit + @CucumberOptions)
src/test/resources/
  FreeRangeNavegacion.feature
  cucumber.properties
🧪 Runner (JUnit)

src/test/java/runner/TestRunner.java

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources",
  glue = "steps",
  plugin = {"pretty", "html:target/cucumber-reports"},
  tags = "@Courses"
)
public class TestRunner { /* ... */ }
🧩 Hooks / Screenshots

src/test/java/steps/Hooks.java toma screenshot en @After cuando el escenario falla y lo adjunta al reporte.

▶️ Cómo correr
Local (headless opcional)
