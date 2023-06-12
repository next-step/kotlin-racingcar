package step3.view

import step3.entity.RacingCar

class OutputView(
    private val lineSymbol: String,
) {
    fun forLabs(racingCars: List<RacingCar>) {
        racingCars.forEach {
            println("${it.name}: ${lineSymbol.repeat(it.position)}")
        }
        println("")
    }

    fun forWinners(winners: List<RacingCar>) {
        println("${getWinnersNames(winners)}가 최종 우승했습니다.")
    }

    private fun getWinnersNames(winners: List<RacingCar>): String =
        winners.map { it.name }
            .reduce { names, name -> "$names, $name" }
}
