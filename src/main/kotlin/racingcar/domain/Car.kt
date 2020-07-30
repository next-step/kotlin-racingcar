package racingcar.domain

const val CAR_MOVE_CRITERIA = 4

class Car(val name: String, var position: Int = 0) {
    fun move(randomValue: Int): Car {
        if (randomValue >= CAR_MOVE_CRITERIA) {
            position += 1
        }
        return this
    }

    fun isWinner(maxPosition: Int): Boolean = maxPosition == this.position

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    override fun toString(): String {
        val repeatBar = "-".repeat(position)
        return "$name : $repeatBar"
    }
}
