package calculator

data class Expression(
    private val input: String?
) {

    companion object {
        private const val DELIMITER_WHITE_SPACE = " "
        private const val OPERATION_REX = "^[+\\-*/\\d]*$"
    }
}
