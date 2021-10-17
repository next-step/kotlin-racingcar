package domain.step3.domain.strategy

@FunctionalInterface
fun interface MovingStrategy {
    fun movable(): Boolean
}
