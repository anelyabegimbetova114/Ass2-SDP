package facade_design_pattern;
// Скрывает сложность системы 
// В этом коде упрощает взаимодействия с различными браузерами и генерацией различных видов отчетов



import java.sql.Driver;

// Класс Firefox предоставляет методы для работы с Firefox-браузером.
class Firefox
{
  public static Driver getFirefoxDriver() 
  {
      return null; // Возвращает экземпляр драйвера Firefox.
  }
  
  public static void generateHTMLReport(String test, Driver driver) 
  {
      System.out.println("Generating HTML Report for Firefox Driver"); // Генерирует HTML-отчет для Firefox.
  }
  
  public static void generateJUnitReport(String test, Driver driver) 
  {
      System.out.println("Generating JUNIT Report for Firefox Driver"); // Генерирует JUNIT-отчет для Firefox.
  }
}

// Класс Chrome предоставляет методы для работы с Chrome-браузером.
class Chrome 
{
  public static Driver getChromeDriver() 
  {
    return null; // Возвращает экземпляр драйвера Chrome.
  }
  
  public static void generateHTMLReport(String test, Driver driver) 
  {
      System.out.println("Generating HTML Report for Chrome Driver"); // Генерирует HTML-отчет для Chrome.
  }
  
  public static void generateJUnitReport(String test, Driver driver)
  {
      System.out.println("Generating JUNIT Report for Chrome Driver"); // Генерирует JUNIT-отчет для Chrome.
  }
}

// Класс WebExplorerHelperFacade представляет собой фасад, который упрощает взаимодействие с браузерами и генерацию отчетов.
class WebExplorerHelperFacade 
{
  public static void generateReports(String explorer, String report, String test)
  {
      Driver driver = null;
      switch(explorer)
      {
          case "firefox":
          driver = Firefox.getFirefoxDriver(); // Получает драйвер Firefox.
          switch(report) 
          {
              case "html":
              Firefox.generateHTMLReport(test, driver); // Генерирует HTML-отчет с использованием Firefox.
              break;
              case "junit":
              Firefox.generateJUnitReport(test, driver); // Генерирует JUNIT-отчет с использованием Firefox.
              break;
          }
          break;
          case "chrome":
          driver = Chrome.getChromeDriver(); // Получает драйвер Chrome.
          switch(report) 
          {
              case "html":
              Chrome.generateHTMLReport(test, driver); // Генерирует HTML-отчет с использованием Chrome.
              break;
              case "junit":
              Chrome.generateJUnitReport(test, driver); // Генерирует JUNIT-отчет с использованием Chrome.
              break;
          }
      }
  }
}

// Главный класс FacadePattern демонстрирует использование фасада для генерации отчетов в разных браузерах.
public class FacadePattern
{
  public static void main(String[] args)
  {
    String test = "CheckElementPresent";
    
    WebExplorerHelperFacade.generateReports("firefox", "html", test); // Генерирует HTML-отчет для Firefox.
    WebExplorerHelperFacade.generateReports("firefox", "junit", test); // Генерирует JUNIT-отчет для Firefox.
    WebExplorerHelperFacade.generateReports("chrome", "html", test);  // Генерирует HTML-отчет для Chrome.
    WebExplorerHelperFacade.generateReports("chrome", "junit", test);  // Генерирует JUNIT-отчет для Chrome.
  }
}
