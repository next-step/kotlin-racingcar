package racing.domain

class CarRacing(
    namesOfCars: List<String>,
    moveStrategy: MoveStrategy,
) {
    private val cars: List<Car> = namesOfCars.map { name -> Car(name, moveStrategy) }

    // TODO : remove
    val positions: List<Int>
        get() = cars.map(Car::position)

    val carInfos: List<CarInfo>
        get() = cars.map { CarInfo(name = it.name, position = it.position) }

    val winnerCarInfos: List<CarInfo>
        get() {
            val maxPosition = cars.maxOf(Car::position)
            return cars.filter { maxPosition == it.position }
                .map { CarInfo(name = it.name, position = it.position) }
        }

    fun move() {
        cars.forEach(Car::move)
    }
}
