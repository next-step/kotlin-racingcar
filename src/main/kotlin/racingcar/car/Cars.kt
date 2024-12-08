package racingcar.car

class Cars : Iterable<Car> {
    val cars = mutableListOf<Car>()

    fun addCar(car: Car) {
        cars.add(car)
    }

    override fun iterator(): Iterator<Car> {
        return cars.iterator()
    }
}
