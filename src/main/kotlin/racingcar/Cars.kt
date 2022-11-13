package racingcar

import racingcar.view.ResultView

class Cars(
    private val cars: List<Car>
) {
    fun getCars() = cars

    fun game(count: Int) {
        repeat(count) {
            this.race()
            ResultView.printCarDistance(this)
        }
    }

    fun getWinners(): List<Car> {
        val max: Int = getMaxDistance()

        return if (max == 0) {
            emptyList()
        } else {
            cars.filter { it.getDistance() == max }
        }
    }

    private fun race() = cars.map { it.moveOrNot() }
    private fun getMaxDistance() = cars.maxOf { it.getDistance() }
}
