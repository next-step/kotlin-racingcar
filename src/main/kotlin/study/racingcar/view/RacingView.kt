package study.racingcar.view

import study.racingcar.domain.Racing

data class RacingView(
    val racing: Racing
) {
    fun printRacing() {
        println("실행 결과")
        // print cars
        racing.cars.map { CarView(it).printPosition() }

        println()
    }
}
