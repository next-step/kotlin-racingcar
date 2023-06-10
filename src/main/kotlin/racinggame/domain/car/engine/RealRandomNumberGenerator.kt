package racinggame.domain.car.engine

class RealRandomNumberGenerator : RandomNumberGenerator {

    override fun generate(range: IntRange): Int {
        return range.random()
    }
}
