package racing.domain

class RacingCars(val cars: List<Car>) {

    init {
        checkValidation()
    }

    fun moveAll() {
        cars.forEach { it.move() }
    }

    fun findWinners(): Winners {
        val maxPosition = cars.maxOf { it.position }
        return Winners(cars.filter { maxPosition == it.position })
    }

    @Throws(IllegalArgumentException::class)
    private fun checkValidation() {
        require(cars.all { it.name.count() <= MAX_NAME_LENGTH }) { "이름은 ${MAX_NAME_LENGTH}자 이하로 가능합니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
