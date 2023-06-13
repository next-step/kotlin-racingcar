package carGame.test

import carGame.domain.Car
import carGame.domain.CarName
import carGame.domain.Cars

object FakeGenerator {
    fun genearteCars(size: Int, position: Int = 0): Cars {
        val cars = List(size) { generateCarName() }.map { Car(name = it, position = position) }
        return Cars(cars)
    }

    fun generateCar(name: String? = null, position: Int): Car {
        val carName = name?.let { CarName(it) } ?: generateCarName()
        return Car(carName, position)
    }

    fun generateCarName(size: Int = 3): CarName {
        return CarName(TestUtil.generateRandomString(size))
    }
}
