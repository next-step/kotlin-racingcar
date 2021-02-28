package racing.domain

internal class RandomMovable(
    private val randomGenerator: RandomGenerator,
    private val max: Int,
    private val threshold: Int
) : Movable {

    override fun isMovable(): Boolean {
        return randomGenerator.nextInt(max) >= threshold
    }
}
