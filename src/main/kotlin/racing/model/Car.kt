package racing.model

class Car {
    fun run() = getMoving()

    companion object {
        private fun getMoving(): Int {
            var moving: Int = (0..9).random()
            moving = if (moving >= 4) moving
            else 0
            return moving
        }
    }
}
