package model

import org.jetbrains.annotations.TestOnly

class Race(
    names: List<String>
) {
    private val cars = names.map { Car(it) }

    fun doRace(): List<Car> {
        cars.forEach {
            it.tryToGo()
        }
        return cars
    }

    @TestOnly
    internal fun getCars() = cars
}
