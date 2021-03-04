package step3_racing_car.game

const val RANDOM_NUMBER = 4

class Car(var position: Int = 0) {
    fun move(condition: Int) {
        if (condition >= RANDOM_NUMBER) {
            position++
        }
    }
}
