package carracing

interface RacingMovementRole<T> {
    fun getMoveDistance(argument: T): Int

    @Throws(IllegalArgumentException::class)
    fun validate(argument: T)
}
