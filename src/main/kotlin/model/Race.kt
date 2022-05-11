package model

class Race(
    numOfCar: Int
) {
    private val cars: List<Car> = List(numOfCar) { Car() }

    fun doRace(): List<Car> {
        cars.forEach {
            it.goStop()
        }
        return cars
    }

    fun getCars() = cars
}