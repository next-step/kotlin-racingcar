package racingcar_winner.model

public class Cars private constructor(
    cars: List<Car>
) {
    private var cars: List<Car> = cars

    fun moveAll(randomNumberFactory: RandomNumberManager) {
        for (car in cars) {
            val randomNumber = randomNumberFactory.generateRandomNumber()
            car.tryToMoveForward(randomNumber)
        }
    }

    fun toList(): List<Car> {
        return cars.toList()
    }

    fun getNumberOfCars(): Int {
        return cars.size
    }

    companion object {
        fun makeCars(carNames: List<String>): Cars {
           val cars = carNames.map { name ->
                Car.makeCar(name)
            }
            return Cars(cars)
        }
    }
}
