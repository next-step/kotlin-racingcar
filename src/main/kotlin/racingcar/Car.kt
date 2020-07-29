package racingcar

fun getRandom(randomStartNum: Int, randomEndNum: Int) = (randomStartNum..randomEndNum).random()
fun greaterThanOrEqualToMovableValue(randomValue: Int) = randomValue >= Car.MOVABLE_VALUE

class Car(val name: String = "car") {
    companion object {
        const val MOVABLE_VALUE = 4
        const val RANDOM_START_NUM = 0
        const val RANDOM_END_NUM = 9
    }

    // private setter 이 클래스 밖에서 이 프로퍼티의 값을 바꿀 수 없다.
    var currentPosition = 0
        private set

    fun isWinner(max: Int) = currentPosition == max

    fun moveForward(): Int {
        if (canMove()) moveOneBlock()
        return currentPosition
    }

    private fun moveOneBlock() {
        currentPosition++
    }

    private fun canMove(): Boolean {
        return greaterThanOrEqualToMovableValue(getRandom(RANDOM_START_NUM, RANDOM_END_NUM))
    }
}
