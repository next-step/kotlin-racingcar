package model

private const val MOVING_THRESHOLD = 4
private const val  MAX_NAME_LENGTH = 5

class RacingCar(
    private var moved: Int,
    private val generator: RandomNumberGenerator,
    private val name: String
) {
    constructor(name: String) : this(1, ZeroToNineGenerator(), name)

    init {
        if(name.length < 0 || name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("[ERROR] The car name cannot exceed $MAX_NAME_LENGTH characters.")
        }
    }

    fun getCurrentState(): Int {
        return moved
    }

    fun moveRandomly() {
        if (generator.generate() >= MOVING_THRESHOLD) {
            moved++
        }
    }
}
