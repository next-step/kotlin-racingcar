package racingcar.view

import racingcar.domain.CarState
import racingcar.domain.CarStates

class ResultView(private val progressCharacter: String = "-") {

    fun displayNowState(states: CarStates) {
        states.cars.forEach { state ->
            displayCarState(state)
        }
        println()
    }

    private fun displayCarState(state: CarState) {
        print("${state.name} : ")
        repeat(state.position) {
            print(progressCharacter)
        }
        println()
    }

    fun displayWinner(winnerStates: List<CarState>) {
        val names = winnerStates.map { statae ->
            statae.name
        }

        println("${names.joinToString()}가 최종 우승했습니다. ")
    }
}
