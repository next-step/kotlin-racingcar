package racingcar.model

import racingcar.exception.Exception.Companion.CASE_INCORRECT_FORMAT_NAME_OF_CAR

/**
 * 자동차들의 객체 관리
 * */
class Cars private constructor(private var _carList: List<Car>) {
    companion object {
        private const val MAX_NAME_OF_CAR = 5
        private const val DELIMITER = ","
        private fun checkValidationOfName(name: String?): String {
            if (name.isNullOrBlank()) throw IllegalArgumentException(CASE_INCORRECT_FORMAT_NAME_OF_CAR)
            if (name.length > MAX_NAME_OF_CAR) throw IllegalArgumentException(CASE_INCORRECT_FORMAT_NAME_OF_CAR)
            return name
        }

        fun splitNameOfCars(names: String): List<String> =
            names.split(DELIMITER).map { checkValidationOfName(it) }

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
