package calculator.validator

interface ExpressionValidator {
    val regex: Regex
    fun validated(input: String?): String
}
