package calculator

class Operator {
    val evaluate = evaluate@{ a: Float, b: Float, operator: String ->
        if (operator == "+") {
            return@evaluate a + b
        }

        if (operator == "-") {
            return@evaluate a - b
        }

        if (operator == "*") {
            return@evaluate a * b
        }

        if (operator == "/") {
            return@evaluate a / b
        }

        return@evaluate throw IllegalArgumentException("유효하지 않은 연산자 입니다.")
    }
}
