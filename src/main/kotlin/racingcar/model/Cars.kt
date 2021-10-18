package racingcar.model

/**
 * 자동차들의 객체 관리
 * */
class Cars private constructor(private var _carList: List<Car>) {
    companion object {
        private const val DELIMITER = ","
        fun splitNameOfCars(names: String): List<String> =
            names.split(DELIMITER)

        fun createCars(raceCondition: RaceCondition): Cars {
            val carList = splitNameOfCars(raceCondition.carsName).map { Car(name = it) }
            return Cars(carList)
        }
    }

    val carList: List<Car>
        get() = this._carList

    fun race(): List<Car> {
        _carList = _carList.map { car -> car.tryMove() }
        return _carList
    }

    fun getWinner(): List<Car> =
        _carList.filter { car -> car.movement == _carList.sortedByDescending { it.movement }[0].movement }
}
