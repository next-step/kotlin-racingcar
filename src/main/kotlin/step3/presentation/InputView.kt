package step3.presentation

import step3.data.RacingCar
import step3.data.RacingCourse

object InputView {
    fun enterCarNumber(): List<RacingCar> {
        println("자동차 대수는 몇 대인가요?")
        val carNumber = readln().toInt()

        return List(carNumber) { RacingCar() }
    }

    fun enterTryCount(): RacingCourse {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readln().toInt()

        return RacingCourse(tryCount)
    }
}
