package racing.ui

import java.lang.NumberFormatException

object RacingInput {

    fun requestNumberOfCars(): Int {
        return try {
            println("자동차 대수는 몇 대인가요?")
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요.")
            requestNumberOfCars()
        }
    }

    fun requestNumberOfRound(): Int {
        return try {
            println("시도할 횟수는 몇 회인가요?")
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요.")
            requestNumberOfRound()
        }
    }
}
