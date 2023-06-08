package racingcar.domain

internal class Car {
    var score = 0
        private set

    fun go() = score++
}
