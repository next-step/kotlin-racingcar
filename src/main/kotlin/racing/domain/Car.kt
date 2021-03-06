package racing.domain

import racing.data.CarState

class Car(
    name: String
) {
    val name = CarName(name)
    val position = CarPosition()

    fun moveCarIfPossible(movementChecker: MovementChecker): CarState {
        if (movementChecker.isMovable()) {
            moveCar()
        }
        return CarState.from(this)
    }

    private fun moveCar() {
        position.increase()
    }
}

class CarName(val name: String) {
    init {
        require(name.length <= NAME_LENGTH_MAX) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        const val NAME_LENGTH_MAX = 5
    }
}

data class CarPosition(private var _position: Int = INIT_POSITION_NUMBER) : Comparable<CarPosition> {

    val position: Int
        get() = _position

    fun increase() {
        _position += 1
    }

    override fun compareTo(other: CarPosition): Int {
        return this.position.compareTo(other.position)
    }

    companion object {
        private const val INIT_POSITION_NUMBER = 0
        val INIT_POSITION = CarPosition()
    }
}
