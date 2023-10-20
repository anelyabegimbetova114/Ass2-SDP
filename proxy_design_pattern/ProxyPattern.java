package proxy_design_pattern;
// Используется функция одного класса в другом  


// Интерфейс DatabaseExecuter определяет метод для выполнения базовых операций с базой данных.
interface DatabaseExecuter 
{
	public void executeDatabase(String query) throws Exception;
}

// Класс DatabaseExecuterImpl реализует интерфейс DatabaseExecuter и предоставляет базовую реализацию выполнения запросов к базе данных.
class DatabaseExecuterImpl implements DatabaseExecuter
{
	@Override
	public void executeDatabase(String query) throws Exception
	{
	    System.out.println("Going to execute Query: " + query);
	}
}

// Класс DatabaseExecuterProxy также реализует интерфейс DatabaseExecuter и действует как прокси для выполнения запросов к базе данных.
class DatabaseExecuterProxy implements DatabaseExecuter
{
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;
	  
	// Конструктор прокси-класса DatabaseExecuterProxy принимает имя и пароль для аутентификации.
	public DatabaseExecuterProxy(String name, String passwd)
	{
	    // Проверяем аутентификацию: если имя и пароль совпадают с администраторскими данными, устанавливаем флаг ifAdmin в true.
	    if(name.equals("Admin") && passwd.equals("Admin@123")) 
	    {
	      ifAdmin = true;
	    }
	    dbExecuter = new DatabaseExecuterImpl(); // Создаем экземпляр класса DatabaseExecuterImpl.
	}

    @Override
	public void executeDatabase(String query) throws Exception
    {
	    if(ifAdmin) 
	    {
	        dbExecuter.executeDatabase(query); // Если пользователь - администратор, выполняем запрос.
	    } 
	    else 
	    {
	        if(query.equals("DELETE")) 
	        {
	            throw new Exception("DELETE not allowed for non-admin user"); // Запрет на выполнение DELETE для обычных пользователей.
	        }
	        else 
	        {
	            dbExecuter.executeDatabase(query); // Для обычных пользователей выполняем другие запросы.
	        }
	    }
	}
}

// Класс ProxyPattern - это точка входа в программу, демонстрирующая использование паттерна Прокси.
public class ProxyPattern
{
	 public static void main(String[] args) throws Exception
	 {
	      // Создание прокси для неадминистратора и попытка выполнить запрос "DELEE".
	      DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
	      nonAdminExecuter.executeDatabase("DELEE");
	    
	      // Создание прокси для неадминистратора и попытка выполнить запрос "DELETE".
	      DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
	      nonAdminExecuterDELETE.executeDatabase("DELETE");

	      // Создание прокси для администратора и выполнение запроса "DELETE".
	      DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
	      adminExecuter.executeDatabase("DELETE");
	 }
}
