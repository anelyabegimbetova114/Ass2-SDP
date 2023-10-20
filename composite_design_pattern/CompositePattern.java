package composite_design_pattern;
// Мы должны относиться к группе объектов как к одному объекту
// Используется для создания иерархии объектов


import java.util.ArrayList;
import java.util.List;

// Абстрактный класс Account, представляющий базовый класс для всех видов счетов
abstract class Account {
  public abstract float getBalance(); // Абстрактный метод для получения баланса счета
}

// Класс DepositeAccount представляет депозитный счет
class DepositeAccount extends Account {
  private String accountNo; // Номер счета
  private float accountBalance; // Баланс счета

  public DepositeAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// Класс SavingAccount представляет сберегательный счет
class SavingAccount extends Account {
  private String accountNo; // Номер счета
  private float accountBalance; // Баланс счета

  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// Класс CompositeAccount представляет составной счет, который может содержать другие счета
class CompositeAccount extends Account {
  private float totalBalance; // Общий баланс составного счета
  private List<Account> accountList = new ArrayList<Account>(); // Список счетов, содержащихся в составном счете

  public float getBalance() {
    totalBalance = 0;
    for (Account acc : accountList) {
      totalBalance += acc.getBalance(); // Вычисление общего баланса, суммируя балансы всех счетов
    }
    return totalBalance;
  }

  public void addAccount(Account acc) {
    accountList.add(acc); // Добавление счета к составному счету
  }

  public void removeAccount(Account acc) {
    accountList.remove(acc); // Удаление счета из составного счета
  }
}

// Класс CompositePattern содержит метод main и используется для демонстрации работы паттерна
public class CompositePattern {
  public static void main(String[] args) {
    CompositeAccount component = new CompositeAccount();

    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));

    float totalBalance = component.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}
