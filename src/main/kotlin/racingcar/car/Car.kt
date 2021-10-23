package racingcar.car

import racingcar.random.Random.randomForward

class Car(var status: Int = 1) {
    fun move() {
        status += randomForward()
    }
}
