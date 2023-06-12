package racing

import kotlin.random.Random

class Car(val name: String) {

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 ${MAXIMUM_NAME_LENGTH}자를 초과할 수 없다."
        }
    }

    var progress = 0

    fun moveCar(): Int {
        if (checkCanGo()) {
            progress++
        }
        return progress
    }

    private fun checkCanGo(): Boolean {
        return getRandomInt() >= GO_RESTRICT_NUMBER
    }

    private fun getRandomInt(): Int {
        return Random.nextInt(MIN_RANGE, MAX_RANGE)
    }

    companion object {
        const val MIN_RANGE = 0
        const val MAX_RANGE = 10
        const val GO_RESTRICT_NUMBER = 4
        const val MAXIMUM_NAME_LENGTH = 5
    }
}
