package racinggame.domain.car.engine

interface RandomNumberGenerator {

    fun generate(range: IntRange): Int
}
