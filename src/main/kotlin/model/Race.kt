package model

import org.jetbrains.annotations.TestOnly

class Race(
    numOfCars: Int
) {
    private val cars: List<Car> = List(numOfCars) { Car() }

    fun doRace(): List<Car> {
        cars.forEach {
            it.goStop()
        }
        return cars
    }

    @TestOnly
    internal fun getCars() = cars
}
