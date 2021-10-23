package racingcar


object ValidationChecker {
    private val intRegex = "\\d".toRegex()
    fun isUnsignedInt(s:String) = s.matches(intRegex)
}
