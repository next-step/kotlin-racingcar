package calculator

class Calculator internal constructor(private val initialState: CalculatorState, private val input: List<String>) {

    constructor(first: Int, input: List<String>) : this(
        OperatorCalculatorState(first), input
    )

    constructor(first: String, input: List<String>) : this(NumberParser.parse(first), input)

    constructor(input: List<String>) : this(input[0], input.drop(1))

    fun calculate(): Int {
        return input.fold(initialState) { state, value ->
            state.input(value)
        }.result()
    }
}
