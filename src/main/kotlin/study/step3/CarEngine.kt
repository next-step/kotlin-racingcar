package study.step3

class CarEngine(
    private val minPerToMove: Int = MIN_RPM_TO_MOVE
) {

    fun accelerate(rpm: Int): Mileage {
        return if (rpm >= minPerToMove) {
            Mileage(1)
        } else {
            Mileage(0)
        }
    }

    companion object {
        const val MIN_RPM_TO_MOVE = 4
    }
}
