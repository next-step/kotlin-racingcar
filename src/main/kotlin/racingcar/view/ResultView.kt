package racingcar.view

import racingcar.domain.RaceHistory

object ResultView {
    private const val CAR_POSITION_STEP = "-"

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printRaceHistories(raceHistories: List<RaceHistory>) {
        raceHistories.forEach {
            printRaceHistory(it)
        }
    }

    private fun printRaceHistory(raceHistory: RaceHistory) {
        raceHistory.cars.forEach {
            println("${it.name} : ${CAR_POSITION_STEP.repeat(it.position) }")
        }
        println()
    }

    fun printRacingChampion(champions: List<String>) {
        println("${champions.joinToString()}가 최종 우승했습니다.")
    }
}
