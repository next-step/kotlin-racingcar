package racing.components

class MovementChecker() {

    companion object {
        const val MAX_RANDOM_NUMBER_PLUS_ONE = 10
        const val MIN_RANDOM_NUMBER_MOVABLE = 4
    }

    private var randomWrapper: RandomWrapper = RandomWrapper()

    constructor(randomWrapper: RandomWrapper) : this() {
        this.randomWrapper = randomWrapper
    }

    fun goodToMove() = randomWrapper.nextInt(MAX_RANDOM_NUMBER_PLUS_ONE) >= MIN_RANDOM_NUMBER_MOVABLE
}
