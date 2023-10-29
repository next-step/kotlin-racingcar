package study.calculator

/**
 * Parser 는 입력받은 문자열을 의미있는 단위(Token)로 파싱 & 검증 후, 계산에 필요한 타입으로 반환합니다.
 *     1. 문자열을 의미있는 단위로 Token 객체로 파싱
 *     2. 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
 *     3. 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
 * */
class Parser() {

    /**
     * 주어진 문자열을 의미있는 단위로 파싱합니다.
     *
     * @param 파싱할 입력 문자열
     * @return 공백 단위로 파싱된 문자 리스트
     * @throws IllegalArgumentException 입력값이 null이거나 빈 공백 문자일 경우
     * */
    fun parse(input: String?): List<Token> {
        if (input.isNullOrEmpty()) throw IllegalArgumentException()
        val tokensList = input
            .split(" ")
            .mapIndexed { index, element ->
                val t = Token()
                if (index % 2 == 0) t.setOperand(element)
                else t.setOperator(element)
                t
            }

        return tokensList
    }

    /**
     * 주어진 문자가 숫자인 경우 해당 숫자를 반환합니다.
     * @param 확인된 숫자 문자열
     * @return int 자료형의 숫자
     * @throws IllegalArgumentException 숫자가 아닌 경우
     */
    fun getInterpretableNumber(num: Token): Int {
        if (num.isInterpretableNumber()) {
            return num.getOperand().toInt()
        } else {
            throw IllegalArgumentException()
        }
    }

    /**
     * 주어진 문자가 연산 가능한 연산자인 경우 해당 연산자를 반환합니다.
     * @param op 확인 및 반환할 연산자 문자
     * @return 연산 가능한 연산자
     * @throws IllegalArgumentException 연산 가능한 연산자가 아닌 경우
     */
    fun getInterpretableOperator(op: Token): String {
        if (op.isInterpretableOperator()) {
            return op.getOperator()
        } else {
            throw IllegalArgumentException()
        }
    }
}
