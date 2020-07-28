package step2

enum class Operator(val symbol: String, var invoke: ((Int, Int) -> Int)) {
    ADD("+", { target: Int, input: Int -> target + input }),
    SUB("-", { target: Int, input: Int -> target - input }),
    MUL("*", { target: Int, input: Int -> target * input }),
    DIV("/", { target: Int, input: Int ->
        if (input == 0)
            throw IllegalArgumentException("Can't be divided by zero.")
        target / input
    })
}