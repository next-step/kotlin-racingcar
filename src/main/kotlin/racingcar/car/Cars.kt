package racingcar.car

class Cars(cars: Collection<Car> = emptyList()) {

    private val cars: Collection<Car> = cars.toList()

    fun move() {
        cars.forEach { it.move() }
    }

    fun getPathStrings(): List<String> {
        return cars.map { it.getPathString() }
    }
}
