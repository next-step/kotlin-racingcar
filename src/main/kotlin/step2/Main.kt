package step2

fun main() {
    println("Enter the formula you want to calculate.")
    val input = readln()
    val validator = Validator()
    validator.validate(input)

    val calculator = Calculator()
    val result = calculator.calculate(input)
    println(result)
}

