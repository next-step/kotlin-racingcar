package calculrate

object Calculator {

    fun calculate(expression: String?): Int {
        require(expression.isNullOrBlank().not())
        return 0
    }
}
