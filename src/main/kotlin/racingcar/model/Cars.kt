package racingcar.model

/**
 * 자동차들의 객체 관리
 * */
class Cars private constructor(var carList: List<Car>) : DriveRule() {
    fun race(): List<Car> {
        return carList.map { car -> car.tryMove(isForward()) }.apply { carList = this }
    }

    fun getWinner(): List<String> =
        carList.filter { car -> car.movement == carList.maxOf { it.movement } }.mapNotNull { it.name }

    companion object {
        fun createCars(raceCondition: RaceCondition): Cars {
            val carList = raceCondition.carsName.map { Car(name = it) }
            return Cars(carList)
        }
    }
}
