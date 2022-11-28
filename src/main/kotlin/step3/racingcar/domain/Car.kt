package step3.racingcar.domain

private const val CAR_ID_DELIMITER = "-"
private const val MOVE_CRITERIA = 4

class Car(val name: String) {
    var distance: Int = 0

    fun race(randomNumber: Int) {
        if (isMove(randomNumber)) {
            distance++
        }
    }

    private fun isMove(randomNumber: Int): Boolean = randomNumber >= MOVE_CRITERIA
}
