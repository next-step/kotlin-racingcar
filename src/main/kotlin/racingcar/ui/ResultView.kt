package racingcar.ui

import racingcar.domain.FormularOne
import racingcar.domain.model.Cars

object ResultView {

    fun show(f1: FormularOne) {
        showResult(f1.totalResult)
        showWinners(f1)
    }

    private fun showResult(result: List<Cars>) {
        println("")
        println("실행 결과")
        result.forEach(::showGameResult)
    }

    private fun showWinners(f1: FormularOne) {
        println("")

        val winners = f1.findWinners()
        val winnerNames = winners.names()

        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun showGameResult(cars: Cars) {
        cars.forEach { car ->
            var result = ""
            repeat(car.position) { result += "-" }
            println("${car.carName.name} : $result")
        }

        println("")
    }
}
