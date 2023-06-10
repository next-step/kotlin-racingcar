package racingcar.output

import racingcar.car.Car

class OutputView {
    fun announceResult() = println("실행 결과")

    fun printCars(cars: List<Car>) {
        cars
            .map { "${it.name} : ${getCarsPosition(it)}" }
            .forEach { println(it) }
    }

    private fun getCarsPosition(it: Car) = POS.repeat(it.distance)

    fun announceRoundStart(round: Int) {
        println("$round 라운드 시작")
    }

    fun printWinner(winners: List<Car>) {
        val winnerCarNames = winners.joinToString(separator = ",") { it.name }
        println("$winnerCarNames 가 최종 우승했습니다.")
    }

    companion object {
        private const val POS: String = "-"
    }
}
