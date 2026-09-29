import kotlin.random.Random

class Employee(
    val name: String,
    val age: Int
) {
    var salary: Int = 0

    override fun toString(): String {
        return "Employee(name='$name', age=$age, salary=$salary)"
    }
}

data class Person(
    val name: Name,
    val address: Address,
    val ownsAPet: Boolean = true
)

data class Name(
    val firstName: String,
    val lastName: String
)

data class Address(
    val street: String,
    val city: City
)

data class City(
    val name: String,
    val state: String
)

data class SalaryEmployee(
    val name: String,
    var salary: Int
)

class RandomEmployeeGenerator(
    var minSalary: Int,
    var maxSalary: Int
) {
    fun generateEmployee(): SalaryEmployee {
        val names = listOf(
            "Alice",
            "Bob",
            "Charlie",
            "David",
            "Eve"
        )

        val name = names.random()
        val salary = Random.nextInt(minSalary, maxSalary + 1)

        return SalaryEmployee(name, salary)
    }
}

fun demonstrateEmployee() {
    val employee = Employee("Mary", 20)

    println(employee)

    employee.salary += 10

    println(employee)
}

fun demonstratePerson() {
    val person = Person(
        name = Name("John", "Smith"),
        address = Address(
            street = "123 Fake Street",
            city = City("Springfield", "US")
        ),
        ownsAPet = false
    )

    println(person)
}

fun demonstrateRandomEmployees() {
    val employeeGenerator = RandomEmployeeGenerator(10, 30)

    println(employeeGenerator.generateEmployee())
    println(employeeGenerator.generateEmployee())
    println(employeeGenerator.generateEmployee())

    employeeGenerator.minSalary = 50
    employeeGenerator.maxSalary = 100

    println(employeeGenerator.generateEmployee())
}

fun main() {
    demonstrateEmployee()
    demonstratePerson()
    demonstrateRandomEmployees()
}