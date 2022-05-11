package racingcar.view.input.parser

interface InputParser<T> {
    fun parseValue(inputString: String?): T
}
