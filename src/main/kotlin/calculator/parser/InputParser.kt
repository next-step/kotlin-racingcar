package calculator.parser

import types.Failure
import types.Success
import types.Try

typealias InputParserOutput = Pair<List<Double>, List<String>>
object InputParser: Parser<
    String,
    InputParserOutput
    > {
    private val basicOperators = listOf("+", "-", "*", "/")
    override fun checkNull(inputStr: String?): Try<String> {
        return inputStr?.let { Success(it) }
            ?: Failure(IllegalArgumentException("입력은 null이 될 수 없습니다."))
    }
    override fun parse(inputStr: String): Try<InputParserOutput> {
        val splitInputStr = inputStr.split(" ")
        return try {
            Success(Pair(
                splitInputStr
                    .filterIndexed { index, _ ->  index % 2 == 0}
                    .map { it -> it.toDouble() },
                splitInputStr
                    .filterIndexed { index, _ ->  index % 2 == 1}
            ))
        } catch (e: NumberFormatException) {
            Failure(IllegalArgumentException("연산 숫자는 숫자 형태이어야 합니다."))
        }
    }
    override fun validate(inputStr: InputParserOutput): Try<InputParserOutput> {
        val invalidNumbers = inputStr.first.filter { it < 0 }
        val invalidOperators = inputStr.second.filter { it !in basicOperators }
        val errorMessage =
            (if (invalidNumbers.isNotEmpty()) "모든 입력 숫자는 0보다 커야 합니다.\n" else "") +
            (if (invalidOperators.isNotEmpty()) "연산자 형식이 유효하지 않습니다." else "")

        return if (errorMessage.isEmpty()) {
            Success(inputStr)
        } else {
            Failure(IllegalArgumentException(errorMessage))
        }
    }
}