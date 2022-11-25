package racingcar.model

import racingcar.model.impl.CarImpl

interface Car {
    val name: Name
    val position: Position
    fun move(factor: MoveFactor)

    companion object {
        fun of(name: String) = CarImpl(Name(name))
        fun of(name: String, position: Int) = CarImpl(Name(name), Position(position))
    }
}
