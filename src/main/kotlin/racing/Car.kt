package racing

class Car(private val moveThreshold : Int = CAR_MOVE_THRESHOLD) {
    var position = 0
        private set

    fun move(power: Int) {
        if (power >= moveThreshold) position++
    }

    companion object {
        private const val CAR_MOVE_THRESHOLD = 4
    }
}