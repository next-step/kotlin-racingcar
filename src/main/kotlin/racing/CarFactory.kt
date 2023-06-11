package racing

import racing.domain.Car
import racing.generator.DefaultNumberGenerator

class CarFactory {

    fun createCarsByInputCount(carCount: Int): List<Car> {
        return (0 until carCount).map {
            Car(moveFlag = DefaultNumberGenerator())
        }
    }

    fun createCarsByInputCarName(inputCarName: String): List<Car> {
        return inputCarName.split(",").map { carName ->
            Car(moveFlag = DefaultNumberGenerator(), name = carName)
        }
    }

    fun getRaceWinnerCars(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

}
