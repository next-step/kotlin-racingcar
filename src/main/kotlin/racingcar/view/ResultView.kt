package racingcar.view

import racingcar.domain.RacingSituation
import racingcar.dto.RacingResult

class ResultView {

    companion object {
        fun printInit() {
            println("\n실행 결과")
        }

        fun printAllRacingSituations(allRacingSituations: List<RacingSituation>) {
            allRacingSituations.forEach { racingSituation: RacingSituation ->
                printRacingSituations(racingSituation)
            }
        }

        private fun printRacingSituations(racingSituation: RacingSituation) {
            racingSituation.racingResults.forEach { racingResult: RacingResult ->
                printPosition(racingResult)
            }
            println()
        }

        private fun printPosition(result: RacingResult) {
            print("${result.car.name} : ")
            List(result.car.position) {
                print("-")
            }
            println()
        }

        fun printWinners(winners: RacingSituation) {
            println(
                "${winners.racingResults.joinToString(
                    separator = ", ", postfix = ""
                ) { it.car.name }}가 최종 우승했습니다."
            )
        }
    }
}
