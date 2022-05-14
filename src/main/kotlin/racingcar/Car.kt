package racingcar

class Car(val name: String, private val seedMaker: SeedMaker) {
    var position = 0
        private set

    private val defaultCarGoDecide = {
        val randomValue = seedMaker.nextInt()

        randomValue >= DEFAULT_CAN_GO_THRESHOLD
    }

    fun proceed() {
        if (canGo()) {
            position++
        }
    }

    private fun canGo(): Boolean {
        return defaultCarGoDecide.invoke()
    }

    fun toCarResult(): CarResult {
        return CarResult(name, position)
    }

    companion object {
        private const val DEFAULT_CAN_GO_THRESHOLD = 4
    }
}
