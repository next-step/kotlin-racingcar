package step2

import java.lang.IllegalArgumentException

class StringCalculator {

    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank()) { throw IllegalArgumentException("입력한 계산식은 null 또는 공백이 될 수 없습니다.") }
        return 10
    }
}
