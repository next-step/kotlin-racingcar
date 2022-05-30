package racingcar.engine

class ConstantEngine(private val advancePoint: Int) : Engine {
    override fun advancePoint(): Int {
        return advancePoint
    }
}
