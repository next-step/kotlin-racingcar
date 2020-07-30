package carracing

private const val STANDARD_COUNT: Int = 3

class Car(val name: String, var position: Int = 0) {
    fun move() {
        if (generateRandomNumber() > STANDARD_COUNT) this.position++
    }

    fun isLocated(requiredPosition: Int): Boolean = position == requiredPosition

    private fun generateRandomNumber(): Int = (0..9).random()

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
}
