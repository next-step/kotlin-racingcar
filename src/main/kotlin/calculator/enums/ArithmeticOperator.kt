package calculator.enums

enum class ArithmeticOperator(private val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/")
    ;

    fun getOperator(): String {
        return this.operator
    }
}
