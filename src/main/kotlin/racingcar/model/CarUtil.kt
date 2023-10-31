package racingcar.model

object CarUtil {
    fun createCars(namesOfCars: List<String>): List<Car> = namesOfCars.map { Car(name = it) }

    fun getWinner(racingHistories: List<RacingHistory>): List<Car> {
        val cars = racingHistories.last().cars
        val maxPosition = cars.maxByOrNull { it.position }?.position
        return cars.filter { it.position == maxPosition }
    }
}
