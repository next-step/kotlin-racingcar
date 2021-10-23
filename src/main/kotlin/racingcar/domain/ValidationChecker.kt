package racingcar.domain

object ValidationChecker {
    private val unsignedNumberRegex = "\\d".toRegex()

    fun isUnsignedInt(s: String) = s.matches(unsignedNumberRegex)
}
