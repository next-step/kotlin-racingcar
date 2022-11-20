package racingcar

class RacingGame(
    private val cars: List<Car>,
    private val numberGenerator: NumberGenerator,
) {

    init {
        requireCarExist(cars)
    }

    fun round(): List<Car> {
        for (car in cars) {
            val randNumber = numberGenerator.rand()
            car.move(randNumber)
        }

        return cars
    }

    fun judge(): List<Car> {
        val maxLocation = cars.maxOf { it.location }
        return cars.filter {
            it.location == maxLocation
        }
    }

    private fun requireCarExist(cars: List<Car>) {
        require(cars.isNotEmpty()) { "레이싱 게임에서 참여하는 자동차는 1대 이상이어야 합니다." }
    }
}
