package calculator

fun main() {
    readln().split(" ")
        .fold(OperandCalculatorState(0, Operator.PLUS)) { acc: CalculatorState, string ->
            acc.input(string)
        }
        .result()
        .let {
            println(it)
        }
}
