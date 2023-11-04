package racingcar

class Car(
    var position: Int = 0,
    var moveCondition: RandomNumberHolder
) {
    fun move() {
        if (moveCondition.getRandomNumber() >= 4) {
            position++
        }
    }
}
