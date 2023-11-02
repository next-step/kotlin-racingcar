package study.racingcar.application

import study.racingcar.domain.RacingCar

/**
 * RacingCar 리스트를 입력 받아서 각 RacingCar 의 상태에 부합하는 UI 를 출력한다.
 * */
class OutputView {
    fun showResult(racingCars: List<RacingCar>) {
        racingCars.forEach {
            println("${it.name} : ${"-".repeat(it.currentPosition)}")
        }
        println()
    }

    fun showWinners(racingCars: List<RacingCar>) {
        val winner = racingCars.maxBy { it.currentPosition }!!
        racingCars
            .filter { it.currentPosition == winner.currentPosition }
            .joinToString(",") { it.name.toString() }
            .let { println("$it 가 최종 우승했습니다.") }
    }
}
