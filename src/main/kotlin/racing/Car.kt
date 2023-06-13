package racing

class Car(val name: String) {

    var progress = 0
        private set

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 ${MAXIMUM_NAME_LENGTH}자를 초과할 수 없다."
        }
    }

    fun moveCar(pedalStrength: Int): Int {
        if (pedalStrength >= GO_RESTRICT_STRENGTH) {
            progress++
        }
        return progress
    }

    companion object {
        const val GO_RESTRICT_STRENGTH = 4
        const val MAXIMUM_NAME_LENGTH = 5
    }
}
