package step3.racingcar.domain

private const val MOVE_CRITERIA = 4
private const val INITIAL_DISTANCE = 0

class Car(val name: String, var distance: Int = INITIAL_DISTANCE) {
    fun race(randomNumber: Int) {
        if (isMove(randomNumber)) {
            distance++
        }
    }

    fun isMaximumDistance(maxDistance: Int): Boolean = distance == maxDistance

    private fun isMove(randomNumber: Int): Boolean = randomNumber >= MOVE_CRITERIA
}
