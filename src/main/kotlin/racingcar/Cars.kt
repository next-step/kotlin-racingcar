package racingcar

import racingcar.view.ResultView

class Cars(
    private val cars: List<Car>
) {
    fun getCars() = cars

    fun game(count: Int) {
        repeat(count) {
            this.race()
            ResultView().printCarDistance(this)
        }
    }

    private fun race() = cars.map { it.moveOrNot() }
}
