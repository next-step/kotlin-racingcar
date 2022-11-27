package racingcar.ui

import racingcar.domain.model.CarRacer

class ResultView {

    fun show(result: List<List<CarRacer>>) {
        println("")
        println("실행 결과")
        result.forEach { gameResult -> showGameResult(gameResult) }
    }

    private fun showGameResult(carRacers: List<CarRacer>) {
        carRacers.forEach { racer ->
            var result = "${racer.name} : "
            repeat(racer.position) { result += "-" }
            println(result)
        }

        println("")
    }
}
