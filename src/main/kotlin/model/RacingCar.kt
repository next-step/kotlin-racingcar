package model

private const val MOVING_THRESHOLD = 4
const val MIN_NAME_LENGTH = 1
const val MAX_NAME_LENGTH = 5

class RacingCar(
    private var moved: Int,
    private val generator: RandomNumberGenerator,
    val name: String
) {
    constructor(name: String) : this(0, ZeroToNineGenerator(), name)

    init {
        require(name.length in MIN_NAME_LENGTH ..MAX_NAME_LENGTH) {
            "[ERROR] The car name should be between $MIN_NAME_LENGTH and $MAX_NAME_LENGTH characters."
        }
    }

    fun moveRandomly() {
        if (generator.generate() >= MOVING_THRESHOLD) {
            moved++
        }
    }

    fun copy(): RacingCar {
        return RacingCar(moved, generator, name)
    }

    fun getMoved(): Int {
        return moved
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as RacingCar
        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
