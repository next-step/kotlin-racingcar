package step2

object CalculatorValidator {

    private const val EVEN_NUMBER_DENOMINATOR = 2
    private const val EVEN_NUMBER_REMAINDER = 0
    private const val ODD_SIZE_REQUIREMENT_MSG = "문자열 사이즈가 3보다 크거나 같은 기수 이여야 한다"
    private const val MINIMUM_SIZE = 3

    fun validateSize(size: Int) {
        require(size >= MINIMUM_SIZE && size % EVEN_NUMBER_DENOMINATOR != EVEN_NUMBER_REMAINDER) { ODD_SIZE_REQUIREMENT_MSG }
    }
}
