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
            List(result.resultPosition) {
                print("-")
            }
            println()
        }
    }
}
