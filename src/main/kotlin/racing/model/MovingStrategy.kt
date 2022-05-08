package racing.model

@FunctionalInterface
interface MovingStrategy {
    fun isMovable(): Boolean
}
