package racingcar.view

import racingcar.domain.RacingResult

class ResultView {

    companion object {
        fun printInit() {
            println("실행 결과")
        }

        fun printResult(result: List<List<RacingResult>>) {
            result.forEach { cars: List<RacingResult> ->
                printRacingResult(cars)
            }
        }

        private fun printRacingResult(cars: List<RacingResult>) {
            cars.forEach { racingResult: RacingResult ->
                printPosition(racingResult)
            }
            println()
        }

        private fun printPosition(result: RacingResult) {
            print("${result.carName} : ")
            List(result.resultPosition) {
                print("-")
            }
            println()
        }

        fun printWinners(result: List<RacingResult>) {
            println("${result.joinToString(separator = ", ", postfix = "") { it.carName }}가 최종 우승했습니다.")
        }
    }
}
