package calculator.ui

import kotlin.math.floor

object SimpleCalculatorView : CalculatorView {
    override fun sayHowToUse() = withDivider {
        println("안녕하세요. 계산기 프로그램을 실행합니다.")
        println("올바른 형태의 사친연산 식을 입력해주세요.")
    }

    override fun input(): String? = readLine()

    override fun sayAnswer(answer: Double) {
        when (floor(answer) == answer) {
            true -> println("정답은 ${answer.toLong()} 입니다.")
            false -> println("정답은 $answer 입니다.")
        }
    }
}
