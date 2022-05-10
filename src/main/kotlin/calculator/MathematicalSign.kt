package calculator

enum class MathematicalSign(
    val sign:String,
    val operation: (Int, Int) -> (Int),
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLE("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    companion object {
        fun getBySign(input: String) = MathematicalSign.values().find { it.sign == input }
    }

}