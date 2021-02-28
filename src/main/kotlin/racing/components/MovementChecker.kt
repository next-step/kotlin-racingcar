package racing.components

class MovementChecker(private var randomWrapper: RandomWrapper = RandomWrapperImpl()) {

    companion object {
        const val MAX_RANDOM_NUMBER_PLUS_ONE = 10
        const val MIN_RANDOM_NUMBER_MOVABLE = 4
    }

    fun goodToMove() = randomWrapper.nextInt(MAX_RANDOM_NUMBER_PLUS_ONE) >= MIN_RANDOM_NUMBER_MOVABLE
}
