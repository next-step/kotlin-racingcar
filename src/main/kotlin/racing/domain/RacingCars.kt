package racing.domain

class RacingCars(private val cars: List<Car>) {

    init {
        checkValidation()
    }

    fun moveAll() {
        cars.forEach { it.move() }
    }

    fun forEach(each: (name: String, position: Int) -> Unit) {
        cars.forEach {
            each(it.name, it.position)
        }
    }

    fun findWinners(): Winners {
        return Winners.from(cars)
    }

    @Throws(IllegalArgumentException::class)
    private fun checkValidation() {
        require(cars.all { it.name.count() <= MAX_NAME_LENGTH }) { "이름은 ${MAX_NAME_LENGTH}자 이하로 가능합니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
