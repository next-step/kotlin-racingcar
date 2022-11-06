package racingcar

class Car(var status: Int = 0) {
    fun move(random: Int) {
        if (random >= MOVE_CONDITION) {
            status++
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        return status
    }

    companion object {
        const val MOVE_CONDITION = 4
    }
}
