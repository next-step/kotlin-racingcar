package racingcar_winner.model

class Cars(
    cars: List<Car>
) {
    private val cars: List<Car> = cars.toList()

    fun moveAll(randomNumberFactory: RandomNumberManager) {
        for (car in cars) {
            val randomNumber = randomNumberFactory.generateRandomNumber()
            car.tryToMoveForward(randomNumber)
        }
    }

    fun toList(): List<Car> {
        return cars.toList()
    }

    override fun toString(): String {
        return cars.joinToString { car -> car.name }
    }
}
