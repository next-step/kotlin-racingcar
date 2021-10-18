package racingcar

class FixedValueCarMoveForwardInputGetter(private val value: Int) : CarMoveForwardValueGetter {
    override fun get(): Int {
        return value
    }
}
