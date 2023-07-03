package racing.model

class Car(val name: String) {
    companion object {
        const val CAR_SYMBOL = "-"
        private const val RANDOM_MIN_NUMBER = 0
        private const val RANDOM_MAX_NUMBER = 9
        private const val LIMIT_ADVANCE = 4
        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
    }

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            "레이싱카 이름은 1글자 이상 5글자 이하입니다."
        }
    }

    var position: Int = 0

    fun run(): Int {
        val randomNumber = (RANDOM_MIN_NUMBER..RANDOM_MAX_NUMBER).random()
        if (randomNumber >= LIMIT_ADVANCE) {
            position++
        }
        return position
    }
}
