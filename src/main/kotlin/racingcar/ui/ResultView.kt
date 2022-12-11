package racingcar.ui

import racingcar.domain.FormularOne
import racingcar.domain.model.CarRacer

object ResultView {

    fun show(f1: FormularOne) {
        showResult(f1.result)
        showWinners(f1)
    }

    private fun showResult(result: List<List<CarRacer>>) {
        println("")
        println("실행 결과")
        result.forEach(::showGameResult)
    }

    private fun showWinners(f1: FormularOne) {
        println("")

        val winners = f1.findWinners()
        val winnerNames = winners.map { carRacer -> carRacer.name }

        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun showGameResult(carRacers: List<CarRacer>) {
        carRacers.forEach { racer ->
            var result = ""
            repeat(racer.position) { result += "-" }
            println("${racer.name} : $result")
        }

        println("")
    }
}
