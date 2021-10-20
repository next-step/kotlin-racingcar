package racingcar.model

/**
 * 자동차들의 객체 관리
 * */
class Cars private constructor(var carList: List<Car>, private val rule: DriveRule) {
    fun race(): List<Car> {
        return carList.map { car -> car.tryMove(rule.isForward()) }.apply { carList = this }
    }

    fun getWinner(): List<String> =
        carList.filter { car -> car.movement == carList.maxOf { it.movement } }.mapNotNull { it.name }

    companion object {
        fun createCars(raceCondition: RaceCondition, rule: DriveRule): Cars {
            val carList = raceCondition.carsName.map { Car(name = it) }
            return Cars(carList, rule)
        }
    }
}
