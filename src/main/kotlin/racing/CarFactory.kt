package racing

import racing.domain.Car
import racing.generator.DefaultNumberGenerator

class CarFactory {

    fun createCarsByInputCount(carCount: Int): List<Car> {
        return (0 until carCount).map {
            Car(numberGenerator = DefaultNumberGenerator())
        }
    }

    fun createCarsByInputCarName(inputCarName: String): List<Car> {
        return inputCarName.split(",").map { carName ->
            Car(numberGenerator = DefaultNumberGenerator(), name = carName)
        }
    }
}
