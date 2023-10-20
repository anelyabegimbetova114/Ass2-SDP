package bridge_design_pattern;
// Разделяет абстракцию и реализацию так, чтобы они могли изменяться независимо друг от друга.


// Абстрактный класс TV, представляющий абстракцию.
abstract class TV 
{
    Remote remote;

    // Конструктор, принимающий объект типа Remote (реализация).
    TV(Remote r) 
    {
        this.remote = r;
    }

    // Абстрактные методы, которые представляют действия для всех TV, но зависят от реализации.
    abstract void on();
    abstract void off();
}

// Класс Sony, наследующийся от TV.
class Sony extends TV
{
    Remote remoteType;

    Sony(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }

    // Реализация методов on и off, используя конкретную реализацию remoteType.
    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Класс Philips, также наследующийся от TV.
class Philips extends TV 
{
    Remote remoteType;

    Philips(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }

    // Реализация методов on и off, используя конкретную реализацию remoteType.
    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Интерфейс Remote, представляющий реализацию.
interface Remote
{
    public void on();
    public void off();
}

// Класс OldRemote, реализующий интерфейс Remote.
class OldRemote implements Remote 
{
    @Override
    public void on()  
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with Old Remote");
    }
}

// Класс NewRemote, также реализующий интерфейс Remote.
class NewRemote implements Remote 
{
    @Override
    public void on() 
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern 
{
    public static void main(String[] args) 
    {
        // Создание объектов Sony и Philips, передавая разные реализации (OldRemote и NewRemote).
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();  
    }
}
