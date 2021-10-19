package racingcar.model

/**
 * 자동차들의 객체 관리
 * */
class Cars private constructor(private var _carList: List<Car>) {
    val carList: List<Car>
        get() = this._carList

    private val maxMovement = _carList.maxByOrNull { it.movement }?.movement

    fun race(): List<Car> {
        _carList = _carList.map { car -> car.tryMove() }
        return _carList
    }

    fun getWinner(): List<String> =
        _carList.filter { car -> car.movement == maxMovement }.mapNotNull { it.name }

    companion object {
        private const val DELIMITER = ","
        fun splitNameOfCars(names: String): List<String> =
            names.split(DELIMITER)

        fun createCars(raceCondition: RaceCondition): Cars {
            val carList = raceCondition.carsName.map { Car(name = it) }
            return Cars(carList)
        }
    }
}
