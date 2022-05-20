package step4.racingcar.racingcar

class Car(
    val racerName: String
) {
    init {
        require(racerName.length <= RACER_NAME_LENGTH_LIMIT) { "입력된 선수의 이름이 5자 이상인 선수가 있습니다." }
    }

    private val _movements: MutableList<Boolean> = mutableListOf()

    val movements
        get() = _movements.toList()

    fun moveOrStop(input: Int) {
        _movements.add(input > GO_NUMBER)
    }

    companion object {
        const val RACER_NAME_LENGTH_LIMIT = 5
        private const val GO_NUMBER = 4
    }
}
