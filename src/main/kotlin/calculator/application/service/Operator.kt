package calculator.application.service

enum class Operator(
    val operator: String,
    val calculate: (Int, Int) -> Int,
) {
    ADD("+", { x, y -> x + y }),
    SUB("-", { x, y -> x - y }),
    MUL("*", { x, y -> x * y }),
    DIV("/", { x, y ->
        if (y == 0) {
            throw ArithmeticException("나누기 연산의 오른쪽 피연산자가 0입니다.")
        }
        x / y
    });
}
