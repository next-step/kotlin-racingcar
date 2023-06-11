import kotlin.random.Random

class Car(val name : String) {

    private var progress = 0

    fun getCarProgress(): Int {
        if (checkCanGo()) {
            progress++
        }
        return progress
    }

    fun checkCanGo(): Boolean {
        return getRandomInt() >= GO_RESTRICT_NUMBER
    }

    fun getRandomInt(): Int {
        return Random.nextInt(MIN_RANGE, MAX_RANGE)
    }

    companion object {
        const val MIN_RANGE = 0
        const val MAX_RANGE = 10
        const val GO_RESTRICT_NUMBER = 4
    }
}
