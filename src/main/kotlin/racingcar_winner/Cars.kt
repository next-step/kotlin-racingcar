package racingcar_winner

class Cars(
    private val cars: List<Car>
) {

    fun getNumberOfCars(): Int = cars.size

    fun playOneRound(randomNumberFactory: RandomNumberFactory) {
        for (car in cars) {
            val randomNumber = randomNumberFactory.generateRandomNumber()
            car.tryToMoveForward(randomNumber)
        }
    }

    fun getProgressOfCars(): List<Int> {
        return cars.map { car ->
            car.progress
        }
    }

    override fun toString(): String {
        return cars.joinToString { car -> car.name }
    }
}
