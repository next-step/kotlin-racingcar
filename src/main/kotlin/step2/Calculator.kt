package step2

class Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("expression is null or blank")
        val tokens = expression.split(" ")
        if (tokens.size % 2 == 0) throw IllegalArgumentException("expression is not completed")
        // TODO 첫번째 토큰을 피연산자로 변환하고 결과값으로 세팅한다.
        // TODO 첫번째 토큰부터 2단계로 루프를 돌린다.
        // TODO i 토큰을 연산자 i+1 토큰을 피연산자로 바꿔준다.
        // TODO 연산자로 계산한 값을 결과값으로 치환한다.
        return -1
    }
}
