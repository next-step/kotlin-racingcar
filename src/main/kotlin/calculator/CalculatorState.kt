package calculator

interface CalculatorState {

    fun input(value: String): CalculatorState

    fun result(): Int
}
