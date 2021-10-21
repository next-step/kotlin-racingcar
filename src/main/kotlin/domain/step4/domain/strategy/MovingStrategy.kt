package domain.step4.domain.strategy

@FunctionalInterface
fun interface MovingStrategy {
    fun movable(): Boolean
}
