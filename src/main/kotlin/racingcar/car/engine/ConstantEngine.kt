package racingcar.car.engine

class ConstantEngine(private val advancePoint: Int) : Engine {
    override fun advancePoint(): Int {
        return advancePoint
    }
}
