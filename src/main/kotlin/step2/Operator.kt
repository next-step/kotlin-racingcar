package step2

enum class Operator(
    val symbol: String,
    val invoke: (Int, Int) -> Int
) {
    ADD("+", { target: Int, input: Int -> target + input }),
    SUB("-", { target: Int, input: Int -> target - input }),
    MUL("*", { target: Int, input: Int -> target * input }),
    DIV(
        "/",
        { target: Int, input: Int ->
            require(input != 0) { "Can't be divided by zero." }
            target / input
        }
    )
}
