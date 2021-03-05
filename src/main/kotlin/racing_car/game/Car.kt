package racing_car.game

const val FORWARD_CRITERIA_NUMBER = 4

const val BASIC_POSITION = 0

class Car {
    var position: Int = BASIC_POSITION
        private set
    fun move(condition: Int) {
        if (condition >= FORWARD_CRITERIA_NUMBER) {
            position++
        }
    }
}
