package study.racingcar

/**
 * Parser 는 입력받은 문자열을 의미있는 단위로 파싱 & 검증 후, 계산에 필요한 타입으로 반환합니다.
 *     1. 문자열을 의미있는 단위로 파싱
 *     2. 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
 *     3. 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
 * */
class Parser {

    /**
     * 주어진 문자열을 의미있는 단위로 파싱합니다.
     *
     * @param 파싱할 입력 문자열
     * @return 공백 단위로 파싱된 문자 리스트
     * @throws IllegalArgumentException 입력값이 null이거나 빈 공백 문자일 경우
     * */
    @Throws(IllegalArgumentException::class)
    fun parse(input: String?): List<String> {
        if (input.isNullOrEmpty()) throw IllegalArgumentException()
        return input.split(" ")
    }

    /**
     * 주어진 문자가 연산 가능한(Int) 범위인지 확인합니다.
     * @param 확인할 문자
     * @return 문자가 숫자인 경우 true, 숫자가 아닌 경우 false를 반환합니다.
     */
    fun isInterpretableNumber(num: String): Boolean {
        return try {
            num.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * 주어진 문자가 숫자인 경우 해당 숫자를 반환합니다.
     * @param 확인된 숫자 문자열
     * @return int 자료형의 숫자
     * @throws IllegalArgumentException 숫자가 아닌 경우
     */
    @Throws(IllegalArgumentException::class)
    fun getInterpretableNumber(num: String): Int {
        if (isInterpretableNumber(num)) {
            return num.toInt()
        } else {
            throw IllegalArgumentException()
        }
    }

    /**
     * 주어진 문자가 연산 가능한 연산자인지 확인합니다.
     * @param op 확인할 연산자 문자
     * @return 연산 가능한 연산자인 경우 true, 그렇지 않은 경우 false를 반환합니다.
     */
    fun isInterpretableOperator(op: String): Boolean {
        return "+-*/".contains(op) && (op.length == 1)
    }

    /**
     * 주어진 문자가 연산 가능한 연산자인 경우 해당 연산자를 반환합니다.
     * @param op 확인 및 반환할 연산자 문자
     * @return 연산 가능한 연산자
     * @throws IllegalArgumentException 연산 가능한 연산자가 아닌 경우
     */
    @Throws(IllegalArgumentException::class)
    fun getInterpretableOperator(op: String): String {
        if (isInterpretableOperator(op)) {
            return op
        } else {
            throw IllegalArgumentException()
        }
    }
}

fun main() {
    val inputString = "2 + 3 * 4 / 2"
    val parser = Parser()
    println(parser)
}
