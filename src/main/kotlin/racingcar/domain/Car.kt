package racingcar.domain

class Car(val name: String, private val seedMaker: SeedMaker) {
    var position = 0
        private set

    fun proceed() {
        if (canGo()) {
            position++
        }
    }

    private fun canGo(): Boolean {
        return seedMaker.nextInt() >= DEFAULT_CAN_GO_THRESHOLD
    }

    companion object {
        private const val DEFAULT_CAN_GO_THRESHOLD = 4
    }
}
