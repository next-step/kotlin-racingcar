package racingcar.view

import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.RaceResult

/**
 * 자동차 경주에서 게임 중 혹은 결과를 출력 모음 class
 * */
class ResultView {
    companion object {
        const val RESULT_TITLE = "실행 결과"
        const val ICON = "\uD83D\uDE80"
    }

    fun printRacing(result: RaceResult) {
        printResultTitle(RESULT_TITLE)
        repeat(result.roundList.size) {
            printStartRound(result.roundList[it].round)
            printRace(result.roundList[it].roundResult.racingCars)
            printEndRound()
        }
        printRaceResult(result.winners)
    }

    private fun printResultTitle(title: String) {
        println()
        println(title)
    }

    private fun printStartRound(round: Int) {
        println("ROUND: $round")
    }

    private fun printEndRound() {
        println("")
    }

    private fun printRace(list: List<Car>) {
        list.forEach { car ->
            val step = StringBuffer("${car.name.carName}: ")
            repeat(car.movement) { step.append(ICON) }
            println(step)
        }
    }

    private fun printRaceResult(list: List<CarName>) {
        val names = list.joinToString { it.carName }
        println("${names}가 최종 우승했습니다.")
    }
}
