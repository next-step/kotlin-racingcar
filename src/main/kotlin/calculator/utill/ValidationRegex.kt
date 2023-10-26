package calculator.utill

object ValidationRegex {
    val EXPRESSION_REGEX = "^[\\d+\\-*/\\s()]+\$".toRegex()
}
