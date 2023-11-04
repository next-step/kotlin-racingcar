package racingcar

class Car(
    private var position: Int = 0,
    private val moveCondition: RandomNumberHolder
) {
    fun move() {
        if (moveCondition.getRandomNumber() >= 4) {
            position++
        }
    }
}
