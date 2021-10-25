package racingcar.parser

object StringParser : Parser {

    private fun stringToList(value: Any): List<String> = value.toString().split(",")

    override fun parse(value: Any): List<String> = stringToList(value)
}
