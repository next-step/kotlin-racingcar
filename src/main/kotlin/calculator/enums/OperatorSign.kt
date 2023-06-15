package calculator.enums

enum class OperatorSign(
    val code: String,
    val calculate: (Int, Int) -> Int
) {
    SUM("+", { x, y -> x + y }),
    SUBSTRACT("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });
}
