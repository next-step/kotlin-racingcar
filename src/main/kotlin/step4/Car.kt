package step4

class Car private constructor(val name: String, val position: Int) {

    fun move(): Car = Car(name, position + 1)

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

    companion object {
        private const val START_POSITION = 1
        fun create(name: String): Car = Car(name, START_POSITION)
    }
}
