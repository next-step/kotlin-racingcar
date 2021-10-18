package racingcar.domain

import racingcar.service.CarMoveForwardDecider

class Car(val number: Int, var position: Int = 0) {
    fun moveForward(carMoveForwardDecider: CarMoveForwardDecider) {
        if (carMoveForwardDecider.canMoveForward()) {
            position++
        }
    }
}
