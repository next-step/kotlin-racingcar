package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Name
import racingcar.domain.Position

class OutputView {

    companion object {
        private const val CAR_POSITION = "\ud83c\udfce\ufe0f"
        private const val RACING_CLOSE_MESSAGE = "가 최종 우승했습니다."
        const val GAME_RESULT_MESSAGE = "실행 결과"

        fun printRaceResults(raceResults: List<Car>) {
            println()
            for (car in raceResults) {
                printCarName(car.name)
                printPosition(car.position)
            }
        }

        fun printRacingWinners(names: List<Name>) {
            println()
            val winners = names.joinToString { it.value }
            println("${winners}$RACING_CLOSE_MESSAGE")
        }

        private fun printCarName(name: Name) {
            print("${name.value}: ")
        }

        private fun printPosition(position: Position) {
            repeat((0 until position.value).count()) {
                print(CAR_POSITION)
            }
            println()
        }
    }
}
