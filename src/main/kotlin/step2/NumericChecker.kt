package step2

object NumericChecker {
    private val numericRegex = "-?\\d+(\\.\\d+)?".toRegex()
    fun checkIsNumeric(s: String) = s.matches(numericRegex)
    fun checkIsNotNumeric(s: String) = !checkIsNumeric(s)
}
