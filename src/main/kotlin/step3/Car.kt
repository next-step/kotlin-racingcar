package step3

class Car private constructor(val position: Int) {

    fun move(): Car = Car(position + 1)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        return position
    }

    companion object {
        private const val START_POSITION = 1
        fun create(): Car = Car(START_POSITION)
    }
}
