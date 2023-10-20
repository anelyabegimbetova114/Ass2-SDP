package adapter_design_pattern;
// используется как мост между двумя интерфейсами, как здесь ChromeDriver имплементирует WebDriver, 
// а потом WebDriverAdapter использует IEDriver для использования WebDriver


// Интерфейс WebDriver определяет стандартный набор методов для работы с веб-элементами.
interface WebDriver 
{
    public void getElement();    // Метод для получения элемента.
    public void selectElement(); // Метод для выбора элемента.
}

// Класс ChromeDriver реализует интерфейс WebDriver и предоставляет реализацию для работы с элементами в Chrome браузере.
class ChromeDriver implements WebDriver 
{
    @Override
    public void getElement() 
    {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement() 
    {
        System.out.println("Select element from ChromeDriver");
    }
}

// Класс IEDriver предоставляет свою собственную реализацию для работы с элементами в Internet Explorer.
class IEDriver
{
    public void findElement() 
    {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement()
    {
        System.out.println("Click element from IEDriver");
    }
}

// Класс WebDriverAdapter реализует интерфейс WebDriver, но использует IEDriver для выполнения соответствующих действий.
class WebDriverAdapter implements WebDriver 
{
    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) 
    {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() 
    {
        // В этом методе адаптер использует IEDriver для получения элемента, переводя вызов к соответствующему методу IEDriver.
        ieDriver.findElement();
    }

    @Override
    public void selectElement() 
    {
        // В этом методе адаптер использует IEDriver для выбора элемента, переводя вызов к соответствующему методу IEDriver.
        ieDriver.clickElement();
    }
}

public class AdapterPattern
{
    public static void main(String[] args) 
    {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();
        
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();
        
        // Создание экземпляра WebDriverAdapter, который позволяет использовать IEDriver как объект WebDriver.
        WebDriver webDriverAdapter = new WebDriverAdapter(ieDriver);
        webDriverAdapter.getElement();
        webDriverAdapter.selectElement();
    }
}
