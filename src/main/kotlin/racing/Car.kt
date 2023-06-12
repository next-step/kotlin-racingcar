import kotlin.random.Random

class Car {

    companion object {
        const val PROGRESS_STRING = "-"
        const val MIN_RANGE = 0
        const val MAX_RANGE = 10
        const val CAN_GO_CONDITION_INT = 4
    }

    private var progressString = StringBuffer(PROGRESS_STRING)

    fun getCarProgress(): String {
        if (checkCanGo()) {
            progressString.append(PROGRESS_STRING)
        }
        return progressString.toString()
    }

    fun checkCanGo(): Boolean {
        return getRandomInt() >= CAN_GO_CONDITION_INT
    }

    fun getRandomInt(): Int {
        return Random.nextInt(MIN_RANGE, MAX_RANGE)
    }
}
