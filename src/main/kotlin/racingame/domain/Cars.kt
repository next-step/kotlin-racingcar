package racingame.domain

class Cars(
    private val values: List<Car> = emptyList()
) {
    val history get() = values.map { it.copy() }

    fun race() {
        values.forEach {
            it.move()
        }
    }
}
