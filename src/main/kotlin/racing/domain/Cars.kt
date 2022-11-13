package racing.domain

class Cars(private val cars: List<Car>) {

    constructor(carNames: String) : this(carNames.split(CAR_NAMES_SPLIT_DELIMITER).map { name -> Car(name) })

    val carInfos: CarInfos
        get() = CarInfos(cars.map { CarInfo(it.name, it.position) })

    fun move() {
        cars.map { car -> car.move() }
    }

    companion object {
        private const val CAR_NAMES_SPLIT_DELIMITER = ","
    }
}
