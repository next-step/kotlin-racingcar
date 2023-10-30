package step4.presentation

import step4.data.RacingCar

object InputView {
    fun enterCars(): List<RacingCar> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val line = readln()
        return parseLine(line)
    }

    private fun parseLine(line: String): List<RacingCar> {
        return line.split(",").map { RacingCar(it) }
    }

    fun enterTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
