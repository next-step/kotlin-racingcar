package racing

class Car(val name: String) {

    var progress = 0
        private set

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 ${MAXIMUM_NAME_LENGTH}자를 초과할 수 없다."
        }
    }

    fun moveCar(randomNumber: Int): Int {
        if (randomNumber >= GO_RESTRICT_NUMBER) {
            progress++
        }
        return progress
    }

    companion object {
        const val GO_RESTRICT_NUMBER = 4
        const val MAXIMUM_NAME_LENGTH = 5
    }
}
