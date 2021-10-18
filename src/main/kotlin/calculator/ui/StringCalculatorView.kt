package calculator.ui

class StringCalculatorView {
    fun welcome() {
        println("계산하려는 사칙연산 식을 입력해주세요.")
    }

    fun input(): String? = readLine()

    fun output(result: Double) {
        println("정답은 $result 입니다.")
    }
}
