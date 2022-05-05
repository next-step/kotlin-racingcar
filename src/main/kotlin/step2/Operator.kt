package step2

enum class Operator {
    PLUS("+", {num1: Int, num2: Int -> num1 + num2 });

    private val mark: String
    var evaluate: (num1: Int, num2: Int) -> Int

    constructor(expr: String, evaluate: (num1: Int, num2: Int) -> Int) {
        this.mark = expr
        this.evaluate = evaluate
    }
}
