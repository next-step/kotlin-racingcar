package racingcar.view.input

import racingcar.view.input.parser.InputParser

object ConsoleReader {

    fun <T> read(message: String, inputParser: InputParser<T>): T {
        var resultValue: T? = null
        while (resultValue == null) {
            println(message)
            resultValue = tryToRead(inputParser)
        }
        return resultValue
    }

    private fun <T> tryToRead(inputParser: InputParser<T>) = try {
        parseString(readLine(), inputParser)
    } catch (e: Exception) {
        println(e.message)
        null
    }

    private fun <T> parseString(inputString: String?, inputParser: InputParser<T>) =
        if (inputString.isNullOrBlank()) null else inputParser.parseValue(inputString)
}
