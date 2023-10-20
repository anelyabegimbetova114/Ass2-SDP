package factory_design_pattern;

// Абстрактный класс Vehicle, определяющий общие методы для всех типов транспортных средств.
abstract class Vehicle 
{
	// Абстрактный метод, который будет реализован в конкретных подклассах.
	public abstract int getWheel();
	
	// Переопределенный метод toString для вывода информации о колесах транспортного средства.
	public String toString() 
	{
	    return "Wheel: " + this.getWheel();
	}
}

// Класс Car, представляющий автомобиль.
class Car extends Vehicle 
{
     int wheel;
	 Car(int wheel)
	 {
	    this.wheel = wheel;
	 }

	 @Override
	 public int getWheel() 
	 {
	    return this.wheel;
	 }
}

// Класс Bike, представляющий велосипед.
class Bike extends Vehicle 
{
	 int wheel;
	 Bike(int wheel) 
	 {
	    this.wheel = wheel;
	 }
	  
	 @Override
	 public int getWheel()
	 {
	    return this.wheel;
	 }
}

// Класс VehicleFactory, реализующий фабричный метод для создания объектов Vehicle.
class VehicleFactory
{
	// Метод getInstance принимает тип транспортного средства и количество колес,
	// и возвращает соответствующий экземпляр конкретного класса (Car или Bike).
	// Это паттерн "Фабричный метод", который инкапсулирует создание объектов.
	 public static Vehicle getInstance(String type, int wheel)
	 {
	    if(type.equals("car")) // Правильное сравнение строк
	    {
	       return new Car(wheel);
	    } 
	    else if(type.equals("bike")) // Правильное сравнение строк
	    {
	       return new Bike(wheel);
	    }
	    return null; // Возвращаем null, если тип не распознан.
	 }
}

// Основной класс FactoryPattern, демонстрирующий использование фабричного метода.
public class FactoryPattern
{
     public static void main(String[] args) 
	 {
	    // Создание автомобиля через фабрику и вывод информации о нем.
	    Vehicle car = VehicleFactory.getInstance("car", 4);
	    System.out.println(car);
	    
	    // Создание велосипеда через фабрику и вывод информации о нем.
	    Vehicle bike = VehicleFactory.getInstance("bike", 2);
	    System.out.println(bike);
	 }
}
