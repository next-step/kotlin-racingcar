package calculator

class Operator {
    val evaluate = evaluate@{ a: Float, b: Float, operator: String ->
        if (operator == "+") {
            return@evaluate a + b
        }

        if (operator == "-") {
            return@evaluate a - b
        }

        return@evaluate a * b
    }
}
