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
        var winnersName = winners[0].name

        for (i in 1 until winners.size) {
            winnersName += ","
            winnersName += winners[i].name
        }
        println("${winnersName}가 최종 우승했습니다.")
    }

    private fun outputForTrials(actualTrial: Int, cars: List<Car>) {
        cars.forEach {
            println("${it.name}$CAR_NAME_SEPARATOR${visualize(actualTrial, it.raceHistory)}")
        }
    }

    private fun visualize(numberOfTrials: Int, raceResult: List<Int>): String {
        var distance = 0

        for (i in 0 until numberOfTrials) {
            distance += raceResult[i]
        }
        return ONE_BLOCK.repeat(distance)
    }
}
