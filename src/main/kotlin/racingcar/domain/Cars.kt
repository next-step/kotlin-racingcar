package racingcar.domain

class Cars(
    private val cars: List<Car>,
) {
    fun move() {
        cars.forEach { it.move() }
    }

    fun move(tryCount: Int) {
        repeat(tryCount) {
            move()
        }
    }

    fun getCars(): List<Car> {
        return cars
    }

    fun getMaxPosition(): Position {
        if (cars.isEmpty()) {
            throw IllegalArgumentException("자동차가 없습니다")
        }

        return cars.maxOfOrNull { it.getPosition().getPosition() }
            ?.let { Position(it) }
            ?: throw IllegalArgumentException("최대 위치를 찾을 수 없습니다")
    }

    fun getWinners(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.isWinner(maxPosition) }
    }
}
