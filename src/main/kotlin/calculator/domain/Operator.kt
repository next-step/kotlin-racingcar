package calculator.domain

enum class Operator(val code: String, val operate: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLE("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });
}
