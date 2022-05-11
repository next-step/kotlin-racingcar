package model

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

    fun getCars() = cars
}
