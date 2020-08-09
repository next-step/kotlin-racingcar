package racing.view

import racing.model.Car

object ResultView {
    private const val CAR_NAME_SEPARATOR = " : "
    private const val ONE_BLOCK = "-"

    fun output(numberOfTrials: Int, cars: List<Car>) {
        (1..numberOfTrials).forEach {
            println("trial$CAR_NAME_SEPARATOR$it")
            outputForTrials(it, cars)
        }
    }

    fun noticeWinner(winners: List<Car>) {
        val winnerNames = winners.joinToString(separator = ",") { it.name }

        println("${winnerNames}가 최종 우승했습니다.")
    }

    private fun outputForTrials(actualTrial: Int, cars: List<Car>) {
        cars.forEach {
            println("${it.name}$CAR_NAME_SEPARATOR${visualize(actualTrial, it)}")
        }
    }

    private fun visualize(numberOfTrials: Int, car: Car): String {
        val distance = car.takeRaceHistory(numberOfTrials)

        return ONE_BLOCK.repeat(distance)
    }
}
