# solid

## Single Responsibility

**Problem**: The ``Employee`` class is overloaded with responsibilities.

```java
public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void saveToDatabase() {
        // ...
    }

    public void printEmployeeReport() {
        // ...
    }
}
```

**Fix**: Add ``EmployeeRepository`` for database tasks and `EmployeeFormatter` for presentation tasks (other names are possible).

## Open Closed

**Problem 1**: The ``EmployeeMySqlDao`` class is tightly coupled to MySQL. If we want to support other databases like PostgreSQL or SQL Server, we either have to modify this class or create new classes with a lot of duplicated code.

```java
public class EmployeeMySqlDao {
    private Connection connection;

    public EmployeeMySqlDao() {
        // init connection
    }

    public void saveEmployee(Employee employee) {
        // ...
    }

    public Employee getEmployeeById(int employeeId) {
        // ...
    }

    public List<Employee> getAllEmployees() {
        // ...
    }
}
```

**Fix**: Introduce an ``IEmployeeDao`` interface. All database-specific DAO classes will implement this interface. This way, they're open for extension (supporting more databases) but closed for modification (no need to change existing code when adding support for a new database).

**Problem 2**: While the base class provides a generic ``executeQuery`` method, subclasses introduce their own database-specific query execution methods, such as ``executeMySqlQuery`` and ``executeOracleQuery``. This creates inconsistencies in method naming and usage. Ìf we want to support more databases in the future, this approach introduces new database-specific methods in every new subclass, rather than leveraging and overriding the methods from the base class.

```java
public class DatabaseAccessor {
    protected String connectionString;

    public DatabaseAccessor(String connectionString) {
        this.connectionString = connectionString;
    }

    public void connect() {
        // ...
    }

    public void executeQuery(String query) {
        // ...
    }
}

public class MySqlDatabaseAccessor extends DatabaseAccessor {
    public MySqlDatabaseAccessor(String connectionString) {
        super(connectionString);
    }

    public void executeMySqlQuery(String query) {
        // ...
    }
}

public class OracleDatabaseAccessor extends DatabaseAccessor {
    public OracleDatabaseAccessor(String connectionString) {
        super(connectionString);
    }

    public void executeOracleQuery(String query) {
        // ...
    }
}
```

**Fix**: Make the base class abstract (or define a common interface) that enforces the implementation of common database operations in the subclasses, then override the ``executeQuery`` method in each subclass to provide the database-specific logic.

## Liskov Substitution Principle

**Problem**: Objects of the superclass ``CoffeeShop`` expect a ``takeaway`` method, but not all subclasses provide a meaningful implementation.

```java
class CoffeeShop {
    String takeaway() { return ""; }
    //...
}
class A extends CoffeeShop  {
    String takeaway() {
        return "Delivery at most 30 minutes";
    }
}
class B extends CoffeeShop {
    String takeaway() {
        throw new RuntimeException("We do not have takeaway service");
    }
}
```

**Fix**: Introduce a ``TakeawayService`` interface to represent classes that offer takeaway capabilities.

## Interface Segregation

**Problem**: ``Traditional`` and ``ThirdWave`` coffee shops, leading subclasses to implement methods they don't need.

```java
interface ICoffeeShop{
    //traditional shops
    void brewByEspressoMachine();
    void brewMachinePourOver();
    //third wave shops
    void brewByHandHeldEspressoMaker();
    void brewManualPourOver();
    //both
    void brewFilterCoffee();
}

class Traditional implements ICoffeeShop { 
    public void brewByEspressoMachine() {
        //...
    } 
    public void brewMachinePourOver() {
        //...
    }  
    public void brewFilterCoffee() {
        //...
    }
    public void brewByHandHeldEspressoMaker() {
        throw new RuntimeException("We don't brewByHandHeldEspressoMaker");
    } 
    public void brewManualPourOver() {
        throw new RuntimeException("We don't brewManualPourOver");
    }
}

class ThirdWave implements ICoffeeShop { 
	public void brewByEspressoMachine() {
        throw new RuntimeException("We don't brewByEspressoMachine");
    } 
	public void brewMachinePourOver() {
        throw new RuntimeException("We don't brewMachinePourOver");
    }
	public void brewFilterCoffee() {
        //...
    }
	public void brewByHandHeldEspressoMaker() {
        //...
    } 
	public void brewManualPourOver() {
        //...
    }  
}
```

**Fix**: Decompose ``ICoffeeShop`` into three focused interfaces

## Dependency Inversion

**Problem**: The ``Delivery`` class is tightly coupled to both ``CoffeeShop`` and ``Customer``.

```java
class CoffeeShop {
    void getPayment() {
    }
    void deliverCoffee() {
    }
}

class Customer { 
    void makePayment() {
    }
    void receiveCoffee() {
    }
}

class Delivery { 

	Customer customer;
	CoffeeShop coffeeShop;
	
	Delivery(Customer customer, CoffeeShop coffeeShop) { }
    void deliver() {
        customer.makePayment();
        coffeeShop.getPayment();
        coffeeShop.deliverCoffee();
        customer.receiveCoffee();
    }
}

```

**Fix**:  Introduce interfaces to ensure that both ``Delivery`` and the involved entities (``CoffeeShop`` and ``Customer``) depend on abstractions, not on concrete implementations.
**Benefits**: 
- You can easily swap out implementation for another without changing the code that uses the interface (useful for mock testing).
- Interfaces decouple the high-level modules (which define policies or workflows) from low-level modules (which implement details). Changes in one module are less likely to impact others.
