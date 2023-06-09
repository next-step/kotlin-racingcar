package step3.domain

typealias CarPositionList = List<Int>

class Game(
    numberOfCars: Int,
    private val numberOfTrials: Int,
) {
    private val cars: List<Car>

    init {
        require(numberOfCars > 0) { "자동차는 1대 이상이어야 합니다." }
        require(numberOfTrials > 0) { "시도 횟수는 1회 이상이어야 합니다." }

        cars = List(numberOfCars) { Car() }
    }

    fun process(): List<CarPositionList> {
        val result: MutableList<CarPositionList> = mutableListOf()

        repeat(numberOfTrials) {
            result.add(doProcess())
        }

        return result
    }

    private fun doProcess(): CarPositionList {
        cars.forEach { it.moveForwardRandomly() }

        return cars.map { it.position }
    }
}
