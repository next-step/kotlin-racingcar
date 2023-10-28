package study.step3.domain

class Car {
    var position = 0

    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }

    fun displayPosition(): String {
        return "-".repeat(position)
    }
}
