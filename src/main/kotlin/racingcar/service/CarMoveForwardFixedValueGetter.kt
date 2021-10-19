package racingcar.service

class CarMoveForwardFixedValueGetter(private val value: Int) : CarMoveForwardValueGetter {
    override fun get(): Int {
        return value
    }
}
