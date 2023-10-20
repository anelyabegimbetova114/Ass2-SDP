package builder_design_pattern;
// Используется для создания объектов с множеством параметров, где не все параметры обязательны. 
// Он позволяет пошагово конфигурировать объекты, обеспечивая гибкость и читаемость кода.


// Основной класс, который будет строить объект Vehicle с помощью вложенного класса VehicleBuilder.
class Vehicle 
{
  private String engine;
  private int wheel;
  private int airbags;
  
  public String getEngine() 
  {
    return this.engine;
  }
  
  public int getWheel() 
  {
    return this.wheel;
  }
  
  public int getAirbags()
  {
    return this.airbags;
  }
  
  // Приватный конструктор, доступный только внутри класса Vehicle. 
  // Он принимает объект VehicleBuilder для построения Vehicle.
  private Vehicle(VehicleBuilder builder)
  {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }
  
  // Вложенный класс VehicleBuilder, который используется для поэтапного создания объектов Vehicle.
  public static class VehicleBuilder
  {
    private String engine;
    private int wheel;
    private int airbags;
    
    // Конструктор VehicleBuilder принимает обязательные параметры, такие как двигатель и колеса.
    public VehicleBuilder(String engine, int wheel)
    {
      this.engine = engine;
      this.wheel = wheel;
    }
    
    // Метод для установки необязательного параметра - количества подушек безопасности.
    public VehicleBuilder setAirbags(int airbags) 
    {
      this.airbags = airbags;
      return this;
    }
    
    // Метод build() создает объект Vehicle с использованием текущих параметров VehicleBuilder.
    public Vehicle build() 
    {
      return new Vehicle(this);
    }
  }
}

// Класс, содержащий метод main для демонстрации использования паттерна Builder.
public class BuilderPattern
{
  public static void main(String[] args) 
  {
    // Создаем объекты Vehicle с разными параметрами, используя VehicleBuilder.
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();
    
    // Выводим параметры каждого созданного транспортного средства.
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());
    
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
