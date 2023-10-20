package flyweight_design_pattern;

// Используется для уменьшения количества создаваемых объектов, 
// сокращения использования памяти и повышения производительности.

import java.util.HashMap;
import java.util.Random;

// Интерфейс Employee описывает общие методы для всех работников.
// Этот интерфейс имеет два метода: assignSkill (назначить навык) и task (выполнить задачу).
interface Employee 
{
  public void assignSkill(String skill);
  public void task();
}

// Класс Developer реализует интерфейс Employee и представляет разработчика.
// Каждый разработчик имеет определенное задание (JOB) и навык (skill).
class Developer implements Employee 
{
  private final String JOB;
  private String skill;
  
  public Developer()
  {
    JOB = "Исправить проблему";
  }
  
  @Override
  public void assignSkill(String skill)
  {
    this.skill = skill;
  }

  @Override
  public void task() 
  {
    System.out.println("Разработчик с навыком: " + this.skill + " и задачей: " + JOB);
  }
}

// Класс Tester реализует интерфейс Employee и представляет тестировщика.
// Каждый тестировщик имеет определенное задание (JOB) и навык (skill).
class Tester implements Employee 
{
  private final String JOB;
  private String skill;
  
  public Tester() 
  {
    JOB = "Проверить проблему";
  }
  
  @Override
  public void assignSkill(String skill)
  {
    this.skill = skill;
  }

  @Override
  public void task()
  {
    System.out.println("Тестировщик с навыком: " + this.skill + " и задачей: " + JOB);
  }
}

// Класс EmployeeFactory создает и управляет работниками (разработчиками и тестировщиками).
// Он использует хэш-карту, чтобы хранить созданных работников и избегать повторного создания.
class EmployeeFactory 
{
  private static HashMap<String, Employee> m = new HashMap<String, Employee>();
  
  public static Employee getEmployee(String type) 
  {
    Employee p = null;
    if(m.get(type) != null) 
    {
      p = m.get(type);
    } 
    else 
    {
      switch(type) 
      {
      case "Developer": 
        System.out.println("Создан разработчик");
        p = new Developer();
        break;
      case "Tester":
        System.out.println("Создан тестировщик");
        p = new Tester();
        break;
      default:
        System.out.println("Нет такого работника");
      }
      
      m.put(type, p);
    }
    return p;
  }
}

// Класс FlyweightPattern - это клиентский класс, который использует фабрику для создания
// работников и назначения им навыков и задач.
public class FlyweightPattern 
{
  private static String employeeType[] = {"Developer", "Tester"};
  private static String skills[] = {"Java", "C++", ".Net", "Python"};
  
  public static void main(String[] args) 
  {
    for(int i = 0; i < 10; i++) 
    {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());     
      e.assignSkill(getRandSkill());
      e.task();
    }
  }
  
  public static String getRandEmployee()
  {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt];
  }
  
  public static String getRandSkill()
  {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt];
  }
}
