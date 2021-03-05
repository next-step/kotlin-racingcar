package racingcar_winner.model

class Cars private constructor(
    private val cars: List<Car>
) {
    fun moveAll(randomNumberFactory: RandomNumberManager) {
        for (car in cars) {
            val randomNumber = randomNumberFactory.generateRandomNumber()
            car.tryToMoveForward(randomNumber)
        }
    }

    fun toList(): List<Car> {
        return cars.toList()
    }

    companion object {
        fun makeCars(cars: List<Car>): Cars {
            return Cars(cars.toList())
        }

        fun convertNamesToCar(carNames: List<String>): List<Car> {
            return carNames.map { name ->
                Car.makeCar(name)
            }
        }
    }
}
