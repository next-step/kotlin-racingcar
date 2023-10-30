package step4.presentation

import step4.domain.RacingCar
import step4.domain.RacingCars

object InputView {
    fun enterCars(): RacingCars {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val line = readln()
        return RacingCars(parseLine(line))
    }

    private fun parseLine(line: String): List<RacingCar> {
        return line.split(",").map { RacingCar(it) }
    }

    fun enterTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
