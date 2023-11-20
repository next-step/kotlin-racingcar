package racingcar.view

import racingcar.domain.RacingSituation
import racingcar.domain.RacingSituations

class ResultView {

    companion object {
        fun printInit() {
            println("\n실행 결과")
        }

        fun printAllRacingSituations(allRacingSituations: List<RacingSituations>) {
            allRacingSituations.forEach { racingSituations: RacingSituations ->
                printRacingSituations(racingSituations)
            }
        }

        private fun printRacingSituations(racingSituations: RacingSituations) {
            racingSituations.racingSituations.forEach { racingSituation: RacingSituation ->
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

        fun printWinners(winners: RacingSituations) {
            println(
                "${
                    winners.racingSituations.joinToString(
                        separator = ", ",
                        postfix = ""
                    ) { it.car.name }
                }가 최종 우승했습니다."
            )
        }
    }
}
