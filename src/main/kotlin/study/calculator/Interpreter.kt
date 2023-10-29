package study.calculator

/**
 * Interpreter 는 Parser 를 주입받아서, 문자열 파싱 후, 이를 의미있는 단위로 해석(계산) 합니다.
 *    1. 문자열 입력받고, 이를 계산
 *    2. 입력받은 문자열의 순서가 계산이 불가능 할 경우, IllegalOperationException throw
 *       - 숫자만 있는 경우
 *       - 연산자가 맨 앞, 뒤에 나오는 경우
 *       - 이외, 숫자 / 연산자 / 숫자 / 연산자 / 숫자 ... 순서가 아닌 경우
 *
 * @property parser 주어진 문자열을 의미있는 단위로 파싱 & 검증 & 반환 하는 객체
 * */
class Interpreter(
    private val parser: Parser,
) {

    lateinit var tokens: List<Token>

    /**
     * 주어진 문자열을 계산 합니다.
     *    1. 검증
     *    2. 계산
     * @param 입력 문자열
     * @return 계산 결과 값
     * @throws IllegalArgumentException 입력값이 null 이거나 빈 공백 문자일 경우
     * */
    fun interpret(input: String): Int {
        checkSemantic(input)
        return calcualte()
    }

    /**
     * 주어진 문자열의 계산 가능 여부를 판별합니다.
     *    1. 문자열 파싱
     *    2. 검증
     * @param 입력 문자열
     * @throws IllegalArgumentException 입력값이 null이거나 빈 공백 문자일 경우
     * */
    fun checkSemantic(input: String) {
        tokens = parser.parse(input)

        val isProperNumbers = tokens.filterIndexed { index, _ -> index % 2 == 0 }
            .all { n ->
                n.isInterpretableNumber()
            }

        val isProperOperators = tokens.filterIndexed { index, _ -> index % 2 == 1 }
            .all { op ->
                op.isInterpretableOperator()
            }

        if (tokens.size % 2 == 0 || !isProperNumbers || !isProperOperators) throw IllegalOperationException("[IllegalOperationException] 계산 가능하도록 입력 문자열을 수정해주세요. (ex. 숫자 / 연산자 / 숫자 / 연산자 / 숫자)")
    }

    /**
     * 주어진 문자열을 계산 합니다.
     *    - numbers, operators를 필터링
     *    - 연산자를 찾는 행위
     *    - 연산자에 해당하는 식을 이용하여 누산하는 행위
     * @param 입력 문자열
     * @return 계산 결과 값
     * @throws IllegalArgumentException 입력값이 null 이거나 빈 공백 문자일 경우
     * */
    fun calcualte(): Int {
        val numbers: List<Token> = tokens.filterIndexed { index, _ -> index % 2 == 0 }
        var operators: List<Token> = tokens.filterIndexed { index, _ -> index % 2 == 1 }
        val firstNumber: Int = parser.getInterpretableNumber(numbers.first())

        val result: Int = numbers.drop(1).fold(firstNumber) { acc, num ->
            val operator: String = parser.getInterpretableOperator(operators.first())
            operators = operators.drop(1)
            when (operator) {
                Operator.PLUS.symbol -> Operator.PLUS.calcFunc(acc, parser.getInterpretableNumber(num))
                Operator.MINUS.symbol -> Operator.MINUS.calcFunc(acc, parser.getInterpretableNumber(num))
                Operator.MULTIPLY.symbol -> Operator.MULTIPLY.calcFunc(acc, parser.getInterpretableNumber(num))
                Operator.DIVIDE.symbol -> Operator.DIVIDE.calcFunc(acc, parser.getInterpretableNumber(num))
                else -> throw IllegalArgumentException()
            }
        }
        return result
    }
}

class IllegalOperationException(message: String) : Exception(message)
