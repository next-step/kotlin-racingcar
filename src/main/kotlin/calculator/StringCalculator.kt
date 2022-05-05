package calculator

class StringCalculator(
    private val expression: String,
) {
    init {
        require(!expression.isNullOrBlank())
    }
}
