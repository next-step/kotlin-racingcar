package study.step3.domain

class Car {
    var position = 0
        private set

    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }
}
