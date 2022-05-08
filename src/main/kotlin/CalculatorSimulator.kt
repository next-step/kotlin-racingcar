import study.Calculator

fun main() {
    print("please input calculation expression :")
    val expression = readln()
    val calculator = Calculator(expression)
    val result = calculator.result()
    println(expression + " = " + result)
}
