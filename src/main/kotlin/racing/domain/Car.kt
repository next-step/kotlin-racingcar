package racing.domain

class Car(val name: String) {

    var position = DEFAULT_POSITION
        private set

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 ${MAXIMUM_NAME_LENGTH}자를 초과할 수 없다."
        }
    }

    fun moveCar(pedalStrength: Int) {
        if (pedalStrength >= GO_RESTRICT_STRENGTH) {
            position++
        }
    }

    companion object {
        const val DEFAULT_POSITION = 0
        const val GO_RESTRICT_STRENGTH = 4
        const val MAXIMUM_NAME_LENGTH = 5
    }
}
