import study.Calculator

fun main() {
    print("please input calculation expression :")
    val expression = readln()
    val calculator = Calculator()
    calculator.append(expression)

    val result = calculator.result()
    calculator.clear()

    println(expression + " = " + result)
}
