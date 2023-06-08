package study.step3.car

class Car {
    private var position: Int = 0

    fun move(moveFlag: Boolean) {
        if (moveFlag) position++
    }

    fun getVisualPosition(): String = "-".repeat(position)
}
