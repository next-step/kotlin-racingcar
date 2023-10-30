package step4.presentation

import step4.data.RacingCar
import step4.data.RacingCourse

object InputView {
    fun showEnterCarIntro() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun enterCars(line: String = readln()): List<RacingCar> {
        return parseLine(line)
    }

    private fun parseLine(line: String): List<RacingCar> {
        return line.split(",").map { RacingCar(it) }
    }

    fun showTryCountIntro() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun enterTryCount(racingCars: List<RacingCar>, tryCount: Int = readln().toInt()): RacingCourse {
        return RacingCourse(tryCount, racingCars)
    }
}
