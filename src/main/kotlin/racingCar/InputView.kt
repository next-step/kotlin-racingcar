package racingCar

import java.lang.IllegalArgumentException

object InputView {

    fun getCarCount(): Int {
        println("경주에 참여할 자동차의 수는?")
        return checkUserInput(readLine())
    }

    fun getTrialCount(): Int {
        println("경주를 시도할 횟수는?")
        return checkUserInput(readLine())
    }

    fun checkUserInput(count: String?): Int {
        try {
            if (count.isNullOrBlank()) throw IllegalArgumentException("값을 입력해주세요.")
            if (count.toInt() < 1) throw IllegalArgumentException("0보다 큰 값만 입력할 수 있습니다.")

            return count.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력가능합니다.")
        }
    }
}
