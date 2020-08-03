package carracing.view

import carracing.CarRacingException

object InputView {

    fun getCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputCarNames = readLine()!!
        if (inputCarNames.isBlank()) {
            throw NullPointerException("자동차 이름을 입력해주세요.")
        }
        return inputCarNames
    }

    fun getCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputCount = readLine()!!
        if (inputCount.isBlank()) {
            throw NullPointerException("숫자로 입력해주세요.")
        }
        var count: Int
        try {
            count = inputCount.toInt()
        } catch (e: NumberFormatException) {
            throw CarRacingException("숫자를 입력해주세요.")
        }
        if (count < 1) {
            throw CarRacingException("자연수를 입력해주세요.")
        }
        return count
    }
}
