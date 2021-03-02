package racingcar_winner.model

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

    fun getProgressOfCars(): Map<String, Int> {
        return cars.map { car ->
            car.name to car.progress
        }.toMap()
    }

    override fun toString(): String {
        return cars.joinToString { car -> car.name }
    }
}
