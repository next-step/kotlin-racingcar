package carracing

class Car(val name: String, var position: Int = 0) {

    fun move(random: Int) {
        if (random >= MOVE_NUMBER_THRESHOLD) {
            position++
        }
    }

    companion object {
        const val MOVE_NUMBER_THRESHOLD = 4
    }
}
