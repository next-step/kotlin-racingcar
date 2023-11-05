package study.racingcar.domain

class Car(
    val name: String,
    position: Int = 0
) {
    var position: Int = position
        private set

    init {
        require(name.length <= 5) { "Car name cannot exceed 5 characters" }
    }

    fun move(randomValue: Int): Car {
        if (randomValue >= MOVABLE_BASE_NUMBER) {
            this.position += 1
        }

        return this
    }

    fun isWin(other: Car) = this.position > other.position

    private companion object {
        const val MOVABLE_BASE_NUMBER = 4
    }
}
