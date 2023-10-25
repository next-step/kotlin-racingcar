package calculator.model

enum class Operator(
    val value: String,
) {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun parseOperators(inputString: String): List<Operator> {
            TODO("Not yet implemented")
        }
    }
}
