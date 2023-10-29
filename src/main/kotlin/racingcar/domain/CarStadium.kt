package racingcar.domain

import racingcar.util.Message.*

class CarStadium(
    numberOfCars: Int,
    private val numberOfTrials: Int
) {

    private val cars: List<Car> = IntRange(1, numberOfCars).map(::Car)

    fun gameStart() : String = buildString {
        this.append(RACE_RESULT_FIRST_LINE.message)
       repeat(numberOfTrials) {
            moving()
            this.append(getMovingResult())
        }
    }

    private fun getMovingResult(symbol : Char = '-'): String = buildString {
        cars.forEach {
            repeat(it.getMoveForwardCount()) { this.append(symbol) }
            this.append("\n")
        }
        this.append("\n")
    }

    private fun moving() {
        cars.filter { CarMove.canMoveForward() }
            .forEach(Car::moveForward)
    }

}
