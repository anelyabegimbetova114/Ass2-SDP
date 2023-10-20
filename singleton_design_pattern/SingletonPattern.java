package singleton_design_pattern;
// Каждая реализация класса этого паттерна обеспечивает создание только одного экземпляра класса 


// SingletonEagar - Жадная инициализация
class SingletonEagar 
{
  private static SingletonEagar instance = new SingletonEagar(); // Экземпляр создается статически при загрузке класса.
  private SingletonEagar()
  {
    // Приватный конструктор - нельзя создавать экземпляры извне класса.
  }
  public static SingletonEagar getInstance()
  {
    return instance; // Возвращает заранее созданный экземпляр.
  }
}

// Singleton - Ленивая инициализация (не потокобезопасен)
class Singleton 
{
  private static Singleton instance; // Экземпляр создается только при первом вызове метода getInstance().
  private Singleton()
  {
    // Приватный конструктор - нельзя создавать экземпляры извне класса.
  }
  public static Singleton getInstance() 
  {
    if(instance == null) 
    {
      instance = new Singleton(); // Создает экземпляр при первом вызове getInstance().
    }
    return instance; // Возвращает один и тот же экземпляр при последующих вызовах.
  }
}

// SingletonSynchronizedMethod - Ленивая инициализация с синхронизированным методом (потокобезопасен)
class SingletonSynchronizedMethod
{
  private static SingletonSynchronizedMethod instance; // Экземпляр создается только при первом вызове метода getInstance().
  private SingletonSynchronizedMethod()
  {
    // Приватный конструктор - нельзя создавать экземпляры извне класса.
  }
  public static synchronized SingletonSynchronizedMethod getInstance() 
  {
    if(instance == null) 
    {
      instance = new SingletonSynchronizedMethod(); // Создает экземпляр при первом вызове getInstance().
    }
    return instance; // Возвращает один и тот же экземпляр при последующих вызовах, с синхронизацией для потокобезопасности.
  }
}

// SingletonSynchronized - Ленивая инициализация с двойной проверкой (потокобезопасен)
class SingletonSynchronized 
{
  private static SingletonSynchronized instance; // Экземпляр создается только при первом вызове метода getInstance().
  private SingletonSynchronized()
  {
    // Приватный конструктор - нельзя создавать экземпляры извне класса.
  }
  public static SingletonSynchronized getInstance() 
  {
    if(instance == null) 
    {
      synchronized (SingletonSynchronized.class) 
      {
        if(instance == null) 
        {
          instance = new SingletonSynchronized(); // Создает экземпляр при первом вызове getInstance().
        }
      }
    }
    return instance; // Возвращает один и тот же экземпляр при последующих вызовах с двойной проверкой для потокобезопасности.
  }
}

public class SingletonPattern 
{
  public static void main(String[] args) 
  {
    SingletonSynchronized instance = SingletonSynchronized.getInstance(); // Получение экземпляра SingletonSynchronized.
    System.out.println(instance); // Вывод экземпляра.
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance(); // Получение того же экземпляра.
    System.out.println(instance1); // Вывод того же экземпляра.
  }
}
