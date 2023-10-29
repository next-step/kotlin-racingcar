package study.step3.domain

class Car {
    private var position = 0

    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}
