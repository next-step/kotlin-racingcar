package racingcar.ui

import racingcar.domain.model.CarRacer

object ResultView {

    fun show(result: List<List<CarRacer>>) {
        showResult(result)
        showWinners(result.last())
    }

    private fun showResult(result: List<List<CarRacer>>) {
        println("")
        println("실행 결과")
        result.forEach(::showGameResult)
    }

    private fun showWinners(
        gameResult: List<CarRacer>
    ) {
        println("")

        val winners: MutableList<String> = mutableListOf()
        val max: Int = gameResult.maxOf { it.position }
        gameResult.forEach {
            if (it.position == max) winners.add(it.name)
        }

        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
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
