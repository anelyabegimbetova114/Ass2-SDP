package decorator_design_pattern;
// Позволяет динамически добавлять новую функциональность объектам, не изменяя их структуру.


// Интерфейс Dress определяет базовую операцию, которую должны выполнять все декораторы.
interface Dress
{
	 public void assemble();
}

// Класс BasicDress представляет базовую реализацию Dress. Он реализует метод assemble, который выводит "Basic Dress Features".
class BasicDress implements Dress 
{
	 @Override
	 public void assemble()
	 {
	    System.out.println("Basic Dress Features");
	 }
}

// Класс DressDecorator - это абстрактный декоратор. Он хранит ссылку на объект типа Dress и реализует метод assemble, который делегирует выполнение базовому объекту.
class DressDecorator implements Dress
{
	 protected Dress dress;
	 public DressDecorator(Dress c)
	 {
	    this.dress = c;
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    this.dress.assemble();
	  }
}

// Классы CasualDress, SportyDress и FancyDress - это конкретные декораторы. Они расширяют функциональность базового объекта, добавляя свои собственные особенности.
class CasualDress extends DressDecorator 
{
	 public CasualDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Casual Dress Features");
	 }
}

class SportyDress extends DressDecorator 
{
	 public SportyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Sporty Dress Features");
	 }
}

class FancyDress extends DressDecorator
{
	 public FancyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble()
	 {
	    super.assemble();
	    System.out.println("Adding Fancy Dress Features");
	 }
}

// Класс DecoratorPattern представляет клиентский код. Он создает различные комбинации декораторов и базового объекта Dress.
public class DecoratorPattern
{
	  public static void main(String[] args) 
	  {
	      Dress sportyDress = new SportyDress(new BasicDress());
	      sportyDress.assemble();
	      System.out.println();
	     
	      Dress fancyDress = new FancyDress(new BasicDress());
	      fancyDress.assemble();
	      System.out.println();
	    
	      Dress casualDress = new CasualDress(new BasicDress());
	      casualDress.assemble();
	      System.out.println();
	    
	      Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
	      sportyFancyDress.assemble();
	      System.out.println();
	    
	      Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
	      casualFancyDress.assemble();
	  }
}
