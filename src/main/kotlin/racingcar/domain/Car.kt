package racingcar.domain

class Car(val carName: String) {
    var distance = 0

    fun forward(randomNumber: Int) {
        if (randomNumber >= MOVE_SUCCESS) distanceIncrease()
    }

    private fun distanceIncrease() {
        distance++
    }

    companion object {
        private const val MOVE_SUCCESS = 4
    }
}
