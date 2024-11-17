package race

class Car(
    private val name: Name,
    private var position: PositiveNumber,
) {
    val progress: Int
        get() = position.value
    val displayName: String
        get() = name.value

    constructor(name: String, position: Int) : this(Name(name), PositiveNumber(position))

    fun move() {
        this.position += PositiveNumber(MOVE_POSITION)
    }

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
        result = 31 * result + position.hashCode()
        return result
    }

    companion object {
        private const val MOVE_POSITION = 1
    }
}
