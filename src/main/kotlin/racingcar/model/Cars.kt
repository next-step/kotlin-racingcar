package racingcar.model

/**
 * 자동차들의 객체 관리 및 경주 관련 메소드 관리
 * */
class Cars private constructor(
    var carList: List<Car>,
    private val raceCondition: RaceCondition,
    private val rule: DriveRule
) {
    fun race(): List<Car> {
        return carList.map { car -> car.tryMove(rule.isForward()) }.apply { carList = this }
    }

    private fun rounds(): List<Round> = (0..raceCondition.tryCount).map { index ->
        Round(index, race())
    }

    fun getWinner(): List<CarName> =
        carList.filter { car -> car.movement == carList.maxOf { it.movement } }.map { it.name }

    fun getResult(): RaceResult = RaceResult(rounds(), getWinner())

    companion object {
        fun createCars(raceCondition: RaceCondition, rule: DriveRule): Cars {
            val carList = raceCondition.carsName.map { Car(name = it) }
            return Cars(carList, raceCondition, rule)
        }
    }
}
