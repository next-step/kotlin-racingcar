package calculator.application.service

enum class Operator(
    val operator: String,
    val calculate: (Int, Int) -> Int,
) {
    ADD("+", { x, y -> x + y }),
    SUB("-", { x, y -> x - y }),
    MUL("*", { x, y -> x * y }),
    DIV("/", { x, y -> x / y });
}
