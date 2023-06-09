package com.racing.step3

class Car(
    var position: Int = 0
) {
    fun move(randomFunc: () -> Int) {
        val randomNum = randomFunc()
        position = if (randomNum >= 4) position + randomNum else position
    }
}
