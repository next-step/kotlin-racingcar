package study.racingcar

/**
 * Interpreter 는 Parser 에서 파싱된 문자열을 의미있는 단위로 해석(계산) 합니다.
 *    1. 문자열 입력받고, 이를 계산
 *    2. 입력받은 문자열의 순서가 계산이 불가능 할 경우, IllegalOperationException throw
 *       - 숫자만 있는 경우
 *       - 연산자가 맨 앞, 뒤에 나오는 경우
 *       - 이외, 숫자 / 연산자 / 숫자 / 연산자 / 숫자 ... 순서가 아닌 경우
 *
 * @property parser 주어진 문자열을 의미있는 단위로 파싱 & 검증 & 반환 하는 객체
 * */
class Interpreter(private val parser: Parser) {

    /**
     * 주어진 문자열의 계산 가능 여부를 판별합니다.
     *
     * @param 입력 문자열
     * @throws IllegalArgumentException 입력값이 null이거나 빈 공백 문자일 경우
     * */
    @Throws(IllegalOperationException::class)
    fun semanticAnalysis(input: String) {
        val parsedInput = parser.parse(input)

        val isProperNumbers = parsedInput.filterIndexed { index, _ -> index % 2 == 0 }
            .all { n -> parser.isInterpretableNumber(n) }

        val isProperOperators = parsedInput.filterIndexed { index, _ -> index % 2 == 1 }
            .all { op -> parser.isInterpretableOperator(op) }

        println("parsedInput: $parsedInput, isProperNumbers: $isProperNumbers, isProperOperators: $isProperOperators")
        if (parsedInput.size % 2 == 0 || !isProperNumbers || !isProperOperators) throw IllegalOperationException("[IllegalOperationException] 계산 가능하도록 입력 문자열을 수정해주세요. (ex. 숫자 / 연산자 / 숫자 / 연산자 / 숫자)")
    }

    /**
     * 주어진 문자열을 계산 합니다.
     *
     * @param 입력 문자열
     * @return 계산 결과 값
     * @throws IllegalArgumentException 입력값이 null 이거나 빈 공백 문자일 경우
     * */
    @Throws(IllegalArgumentException::class)
    fun interpret(input: String): Int {
        val parsedInput: List<String> = parser.parse(input)
        val numbers: List<String> = parsedInput.filterIndexed { index, _ -> index % 2 == 0 }
        var operators: List<String> = parsedInput.filterIndexed { index, _ -> index % 2 == 1 }
        val firstNumber: Int = parser.getInterpretableNumber(numbers.first())
        val result: Int = numbers.drop(1).fold(firstNumber) { acc, num ->
            val operator: String = parser.getInterpretableOperator(operators.first())
            operators = operators.drop(1)
            when (operator) {
                "+" -> acc + parser.getInterpretableNumber(num)
                "-" -> acc - parser.getInterpretableNumber(num)
                "*" -> acc * parser.getInterpretableNumber(num)
                "/" -> acc / parser.getInterpretableNumber(num)
                else -> throw IllegalArgumentException()
            }
        }
        return result
    }
}

class IllegalOperationException(message: String) : Exception(message)
