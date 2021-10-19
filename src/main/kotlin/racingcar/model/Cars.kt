package racingcar.model

/**
 * 자동차들의 객체 관리
 * */
class Cars private constructor(var carList: List<Car>) : DriveRule() {
    private val maxMovement = carList.maxByOrNull { it.movement }?.movement

    fun race(): List<Car> {
        carList = carList.map { car -> car.tryMove(isForward()) }
        return carList
    }

    fun getWinner(): List<String> =
        carList.filter { car -> car.movement == maxMovement }.mapNotNull { it.name }

    companion object {
        fun createCars(raceCondition: RaceCondition): Cars {
            val carList = raceCondition.carsName.map { Car(name = it) }
            return Cars(carList)
        }
    }
}
