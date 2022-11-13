package racingcar.util

import racingcar.extension.removeWhitespaces

object Parser {
    private val COMMA_SPLIT_REGEX = ",".toRegex()

    fun parse(rawString: String?): List<String> {
        Validator.validateParserStr(rawString)
        val removeWhiteString = rawString!!.removeWhitespaces()
        return removeWhiteString.split(COMMA_SPLIT_REGEX)
    }
}
