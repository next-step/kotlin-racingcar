package racingcar.view

import racingcar.domain.RacingSituation

class ResultView {

    companion object {
        fun printInit() {
            println("\n실행 결과")
        }

        fun printAllRacingSituations(allRacingSituations: List<List<RacingSituation>>) {
            allRacingSituations.forEach { racingSituations: List<RacingSituation> ->
                printRacingSituations(racingSituations)
            }
        }

        private fun printRacingSituations(racingSituations: List<RacingSituation>) {
            racingSituations.forEach { racingSituation: RacingSituation ->
                printPosition(racingSituation)
            }
            println()
        }

        private fun printPosition(result: RacingSituation) {
            print("${result.car.name} : ")
            List(result.car.position) {
                print("-")
            }
            println()
        }

        fun printWinners(winners: List<RacingSituation>) {
            println("${winners.joinToString(separator = ", ", postfix = "") { it.car.name }}가 최종 우승했습니다.")
        }
    }
}
