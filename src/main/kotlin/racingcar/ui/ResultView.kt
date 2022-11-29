package racingcar.ui

import racingcar.domain.model.CarRacer

object ResultView {

    fun show(result: List<List<CarRacer>>) {
        println("")
        println("실행 결과")
        result.forEachIndexed { index, gameResult ->
            showGameResult(gameResult)
            showWinners(result.lastIndex, index, gameResult)
        }
    }

    private fun showWinners(
        lastIndex: Int,
        index: Int,
        gameResult: List<CarRacer>
    ) {
        if (lastIndex != index) return
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
            var result = "${racer.name} : "
            repeat(racer.position) { result += "-" }
            println(result)
        }

        println("")
    }
}
