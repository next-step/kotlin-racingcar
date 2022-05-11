package carRacing

class Car {
    var distance = 0

    fun forward() {
        distance += MOVE_DISTANCE
    }

    companion object {
        private const val MOVE_DISTANCE = 1
    }
}