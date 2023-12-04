package racing.view

import racing.PlayCarList
import racing.ResultData

object ResultView {
    private const val FIXED_INDEX = 1

    fun showRacingResult(resultData: ResultData) {
        val resultDataList = resultData.resultDataList


        resultDataList.forEachIndexed { index, racingResult ->
            println("${index + FIXED_INDEX}회차 경주")
            printRacingResult(racingResult)
            println()
        }
        printRacingCar(resultData.resultDataList.last())
    }

    private fun printRacingResult(playCarList: PlayCarList) {
        playCarList.carList.forEach {
            println("${it.name} " + "-".repeat(it.position))
        }
    }

    private fun printRacingCar(lastPlayResult: PlayCarList) {
        val winners = lastPlayResult.getWinners().joinToString(", ") { it.name }
        println("${winners}가 우승하였습니다.")
    }
}
