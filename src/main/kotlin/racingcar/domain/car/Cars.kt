package racingcar.domain.car

class Cars(private val cars: List<Car>) : List<Car> by cars {

    constructor(carNames: CarNames) : this(carNames.mapToCar())

    fun race(): Cars = Cars(cars.map { it.drive() })
}
