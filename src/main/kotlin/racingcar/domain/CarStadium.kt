package racingcar.domain

class CarStadium(
    numberOfCars: Int,
    private val numberOfTrials: Int,
    private val random: RandomGenerator<Int>
) {

    private val cars: List<Car> = List(numberOfCars) { Car(it) }

    fun gameStart() : String = buildString {
        repeat(numberOfTrials) {
            moving()
            this.append(getMovingResult())
        }
    }

    private fun getMovingResult(symbol : Char = '-'): String = buildString {
        cars.forEach {
            repeat(it.moveForwardCount) { this.append(symbol) }
            this.append("\n")
        }
        this.append("\n")
    }

    private fun moving() {
        cars.filter { CarMove.canMoveForward(random.generate()) }
            .forEach(Car::moveForward)
    }

}
