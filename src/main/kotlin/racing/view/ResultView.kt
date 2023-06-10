package racing.view

import racing.car.RacingCar

class ResultView {
    private val RACING_MARK = '-'
    fun showGameBoard(racingCars: List<RacingCar>) {
        racingCars.forEach {
            for (i: Int in 0..it.position) {
                print(RACING_MARK)
            }
            println()
        }
    }
}
