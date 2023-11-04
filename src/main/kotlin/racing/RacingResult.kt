package racing

import racing.car.Car

class RacingResult {
    fun showRacingResult(racingRoundResults: List<List<Car>>) {
        racingRoundResults.forEachIndexed { index, racingResult ->
            println("${index + FIXED_INDEX}회차 경주")
            printRacingResult(racingResult)
            println()
        }
        // car, cat이 우승하였습니다.
        printRacingCar(getWinnerList(racingRoundResults.last()))
    }

    private fun printRacingResult(singleRoundResults: List<Car>) {
        singleRoundResults.forEach {
            println("${it.name} " + "-".repeat(it.position))
        }
    }

    private fun printRacingCar(winnerList: List<Car>) {
        val sb = StringBuilder()

        sb.append(winnerList.first().name)
        if (winnerList.size > 2) {
            winnerList.forEach { sb.append(", ${it.name}") }
        }
        sb.append("가 우승하였습니다.")
        println(sb.toString())
    }

    private fun getWinnerList(lastRacingRoundResult: List<Car>): List<Car> {
        val maxPosition = lastRacingRoundResult.maxOf { it.position }
        return lastRacingRoundResult.filter { it.position == maxPosition }
    }

    companion object {
        const val FIXED_INDEX = 1
    }
}
