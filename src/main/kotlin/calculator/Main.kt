package calculator

fun main() {

    readln()
        .split(" ")
        .fold(OperandCalculatorState(0, Operator.PLUS) as CalculatorState) { state, value ->
            state.input(value)
        }
        .result()
        .let(::println)
}
