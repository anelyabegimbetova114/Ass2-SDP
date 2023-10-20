package observer_design_pattern;
//  используется в случаях, когда существует отношение "один ко многим" между объектами, 
// так что если один объект изменяется, его зависимые объекты автоматически уведомляются о этом изменении.


import java.util.ArrayList;
import java.util.List;

// Интерфейс Subject определяет методы, которые должны быть реализованы классами, 
// которые хотят уведомлять наблюдателей о изменениях.
interface Subject 
{
    void register(Observer obj);    // Регистрирует наблюдателя.
    void unregister(Observer obj);  // Отменяет регистрацию наблюдателя.
    void notifyObservers();         // Уведомляет наблюдателей об изменении.
}

// Класс DeliveryData реализует интерфейс Subject. Он хранит список наблюдателей
// и уведомляет их о изменениях в местоположении.
class DeliveryData implements Subject
{
    private List<Observer> observers; // Список наблюдателей
    private String location;          // Текущее местоположение груза
  
    public DeliveryData() 
    {
        this.observers = new ArrayList<>();
    }
  
    @Override
    public void register(Observer obj) 
    {
        observers.add(obj); // Регистрирует наблюдателя, добавляя его в список.
    }

    @Override
    public void unregister(Observer obj) 
    {
        observers.remove(obj); // Отменяет регистрацию наблюдателя, удаляя его из списка.
    }

    @Override
    public void notifyObservers()
    {
        for (Observer obj : observers) 
        {
            obj.update(location); // Уведомляет каждого наблюдателя об изменении.
        }
    }

    public void locationChanged()
    {
        this.location = getLocation(); // Метод, который меняет местоположение и уведомляет наблюдателей.
        notifyObservers();
    }
  
    public String getLocation() 
    {
      return "YPlace"; // Метод, возвращающий местоположение (здесь фиксировано "YPlace").
    }
}

// Интерфейс Observer определяет метод update, который вызывается при обновлении состояния объекта.
interface Observer
{
    public void update(String location);
}

// Класс Seller реализует интерфейс Observer и реагирует на обновления местоположения.
class Seller implements Observer 
{
    private String location; // Местоположение продавца
  
    @Override
    public void update(String location)
    {
        this.location = location; // Обновляет местоположение продавца.
        showLocation(); // Выводит информацию о текущем местоположении.
    }

    public void showLocation()
    {
        System.out.println("Уведомление для Продавца - Текущее местоположение: " + location);
    }
}

// Класс User реализует интерфейс Observer и реагирует на обновления местоположения.
class User implements Observer 
{
    private String location; // Местоположение пользователя
  
    @Override
    public void update(String location) 
    {
        this.location = location; // Обновляет местоположение пользователя.
        showLocation(); // Выводит информацию о текущем местоположении.
    }

    public void showLocation() 
    {
        System.out.println("Уведомление для Пользователя - Текущее местоположение: " + location);
    }
}

// Класс DeliveryWarehouseCenter реализует интерфейс Observer и реагирует на обновления местоположения.
class DeliveryWarehouseCenter implements Observer
{
    private String location; // Местоположение центра доставки
  
    @Override
    public void update(String location)
    {
        this.location = location; // Обновляет местоположение центра доставки.
        showLocation(); // Выводит информацию о текущем местоположении.
    }

    public void showLocation()
    {
        System.out.println("Уведомление для Центра доставки - Текущее местоположение: " + location);
    }
}

public class ObserverPattern
{
    public static void main(String[] args)
    {
        DeliveryData topic = new DeliveryData(); // Создание объекта субъекта (темы доставки).
    
        Observer obj1 = new Seller(); // Создание объекта продавца в качестве наблюдателя.
        Observer obj2 = new User(); // Создание объекта пользователя в качестве наблюдателя.
        Observer obj3 = new DeliveryWarehouseCenter(); // Создание объекта центра доставки в качестве наблюдателя.
    
        topic.register(obj1); // Регистрация продавца как наблюдателя.
        topic.register(obj2); // Регистрация пользователя как наблюдателя.
        topic.register(obj3); // Регистрация центра доставки как наблюдателя.
        
        topic.locationChanged(); // Имитация изменения местоположения.
        topic.unregister(obj3); // Отмена регистрации центра доставки.
    
        System.out.println();
        topic.locationChanged(); // Имитация ещё одного изменения местоположения.
    }
}
