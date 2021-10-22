package racingcar.model

/**
 * 자동차들의 객체 관리 및 경주 관련 메소드 관리
 * */
class Cars private constructor(
    var carList: RacingCars,
    private val raceCondition: RaceCondition,
    private val rule: DriveRule
) {
    fun race(): RacingCars =
        carList.racingCars.map { car -> car.tryMove(rule.isForward()) }.run {
            carList.racingCars = this
            RacingCars(carList.racingCars)
        }

    private fun rounds(): List<Round> = (0..raceCondition.tryCount).map { index ->
        Round(index, race())
    }

    private fun getWinner(): List<CarName> =
        carList.racingCars.filter { car -> car.movement == carList.racingCars.maxOf { it.movement } }.map { it.name }

    fun getResult(): RaceResult = RaceResult(rounds(), getWinner())

    companion object {
        fun createCars(raceCondition: RaceCondition, rule: DriveRule): Cars {
            val carList = raceCondition.carsName.map { Car(name = it) }
            return Cars(RacingCars(carList), raceCondition, rule)
        }
    }
}
