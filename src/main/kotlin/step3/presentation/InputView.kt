package step3.presentation

import step3.data.RacingCourse

object InputView {
    fun enterData(): RacingCourse {
        println("자동차 대수는 몇 대인가요?")
        val carNumber = readln().toInt()
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readln().toInt()

        return RacingCourse(carNumber, tryCount)
    }
}
