package racingcar

class Car(val name: String, private val movingStrategy: MovingStrategy) {
    var position: Int = START_POSITION

    fun attemptsMoveForward() {
        if (movingStrategy.movable()) {
            this.position++
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        const val START_POSITION: Int = 1
    }
}
