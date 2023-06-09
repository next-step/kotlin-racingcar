package com.racing.step3

class Car(
    var position: Int = 0
) {
    fun move(randomFunc: () -> Int): Car {
        val randomNum = randomFunc()
        return if (randomNum >= 4) Car(position + 1) else this
    }
}
