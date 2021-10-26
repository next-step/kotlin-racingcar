package racingcar.parser

object StringParser : Parser {

    private fun stringToList(value: Any): List<String> = value.toString().split(",").map { it.trim() }

    override fun parse(value: Any): List<String> = stringToList(value)
}
