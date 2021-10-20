package step2

object NumericChecker {
    fun checkIsNumeric(s: String) = s.matches("-?\\d+(\\.\\d+)?".toRegex())
    fun checkIsNotNumeric(s: String) = !checkIsNumeric(s)
}
