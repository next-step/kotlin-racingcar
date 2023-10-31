package calculator.parser

import types.Failure
import types.Success
import types.Try

typealias ParserOutputType = ParserOutput<Double, String>
object InputParser : Parser<
        String,
        ParserOutputType
        > {
    private val basicOperators = listOf("+", "-", "*", "/")
    override fun checkNull(inputStr: String?): Try<String> {
        return inputStr?.let { Success(it) }
            ?: Failure(IllegalArgumentException("입력은 null이 될 수 없습니다."))
    }
    override fun parse(inputStr: String): Try<ParserOutputType> {
        val splitInputStr = inputStr.split(" ")
        return try {
            Success(getParseOutput(splitInputStr))
        } catch (e: NumberFormatException) {
            Failure(IllegalArgumentException("연산 숫자는 숫자 형태이어야 합니다."))
        }
    }
    override fun validate(inputStr: ParserOutputType): Try<ParserOutputType> {
        val invalidNumbers = inputStr.numbers.filter { it < 0 }
        val invalidOperators = inputStr.operands.filter { it !in basicOperators }
        val errorMessage =
            (if (invalidNumbers.isNotEmpty()) "모든 입력 숫자는 0보다 커야 합니다.\n" else "") +
                (if (invalidOperators.isNotEmpty()) "연산자 형식이 유효하지 않습니다." else "")

        return if (errorMessage.isEmpty()) {
            Success(inputStr)
        } else {
            Failure(IllegalArgumentException(errorMessage))
        }
    }
    private fun getParseOutput(splitInputStr: List<String>): ParserOutputType {
        return ParserOutput(
            splitInputStr
                .filterIndexed { index, _ -> index % 2 == 0 }
                .map { it -> it.toDouble() },
            splitInputStr
                .filterIndexed { index, _ -> index % 2 == 1 }
        )
    }
}
