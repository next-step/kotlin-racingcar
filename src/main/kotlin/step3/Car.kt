package step3

import step3.UI.ResultView

class Car {
    var position = 0
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position++
        }
        ResultView.show(position)
    }

    companion object {
        val instance: Car
            get() = Car()
    }
}

