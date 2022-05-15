package raicing.model

import raicing.strategy.MovingStrategy

data class Car(val name: String, val position: Int = INIT_POSITION) {

    fun moveForward(movingStrategy: MovingStrategy): Car {
        return if (movingStrategy.canMoveForward())
            copy(position = position + 1)
        else
            this
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
