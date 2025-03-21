package model

private const val MOVING_THRESHOLD = 4

class RacingCar(private var moved: Int, private var generator: RandomNumberGenerator) {
    constructor() : this(1, ZeroToNineGenerator())

    fun getCurrentState(): Int {
        return moved
    }

    fun moveRandomly() {
        if (generator.generate() >= MOVING_THRESHOLD) {
            moved++
        }
    }
}
