package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Name
import racingcar.domain.Position

class OutputView {

    companion object {
        private const val CAR_POSITION = "\ud83c\udfce\ufe0f"
        const val GAME_RESULT_MESSAGE = "실행 결과"

        fun printRaceResults(raceResults: List<Car>) {
            println()
            for (car in raceResults) {
                printCarName(car.name)
                printPosition(car.position)
            }
        }

        private fun printCarName(name: Name) {
            print("${name.value}: ")
        }

        private fun printPosition(position: Position) {
            (0 until position.value).forEach {
                print(CAR_POSITION)
            }
            println()
        }
    }
}
