package prototype_design_pattern;

// Позволяет создавать клон объекта с теми же данными, но независимым от оригинала

import java.util.ArrayList;
import java.util.List;

// Класс `Vehicle` представляет основной прототип объекта.
// Он содержит список строк `vehicleList`, который представляет список автомобилей.
// Метод `insertData` заполняет список некоторыми значениями по умолчанию.
// Метод `clone` выполняет глубокое копирование объекта `Vehicle`.
class Vehicle implements Cloneable 
{
  private List<String> vehicleList;
  
  public Vehicle() 
  {
    this.vehicleList = new ArrayList<String>();
  }
  
  public Vehicle(List<String> list) 
  {
    this.vehicleList = list;
  }
  
  public void insertData()
  {
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }
  
  public List<String> getVehicleList() 
  {
    return this.vehicleList;
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException 
  {
    List<String> tempList = new ArrayList<String>();
    
    for(String s : this.getVehicleList()) 
    {
      tempList.add(s);
    }
    
    return new Vehicle(tempList);
  }
}

public class PrototypePattern
{
  public static void main(String[] args) throws CloneNotSupportedException 
  {
    Vehicle a = new Vehicle();
    a.insertData();
    
    // Создается клон объекта `a` с использованием метода `clone`.
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    
    // Мы можем изменять данные в клоне без воздействия на оригинал.
    list.add("Honda new Amaze");
    
    System.out.println(a.getVehicleList()); // Вывод списка автомобилей из оригинала
    System.out.println(list); // Вывод списка автомобилей из клонированного объекта
    
    // Удаление элемента из клонированного списка не влияет на оригинал.
    b.getVehicleList().remove("Audi A4");
    System.out.println(list); // Вывод обновленного списка автомобилей из клонированного объекта
    System.out.println(a.getVehicleList()); // Вывод списка автомобилей из оригинала
  }
}
