package racing.domain

class Cars(private val cars: List<Car>) {

    constructor(carNames: String, moveStrategy: MoveStrategy = RandomStrategy.instance)
            : this(carNames.split(CAR_NAMES_SPLIT_DELIMITER).map { name -> Car(name, moveStrategy) })

    fun move(): CarInfos {
        return CarInfos(cars.map { it.move() })
    }

    companion object {
        private const val CAR_NAMES_SPLIT_DELIMITER = ","
    }
}
