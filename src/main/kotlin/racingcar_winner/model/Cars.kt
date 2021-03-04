package racingcar_winner.model

public class Cars private constructor(
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
            return Cars(cars)
        }

        fun convertNamesToCar(carNames: List<String>): List<Car> {
            return carNames.map { name ->
                Car.makeCar(name)
            }
        }
    }
}
