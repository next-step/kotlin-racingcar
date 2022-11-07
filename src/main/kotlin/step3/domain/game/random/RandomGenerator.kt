package step3.domain.game.random

interface RandomGenerator<T> {

    val randomPredicate: (T) -> Boolean

    val candidates: Collection<T>

    fun random(): T

    fun randomValid(): Boolean = randomPredicate(random())
}
