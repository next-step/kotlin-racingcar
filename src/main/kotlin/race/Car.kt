package race

class Car(val name: String) {
    fun move(randomNumber: Int): Boolean {
        return randomNumber >= THRESHOLD
    }

    init {
        require(name.length > CAR_NAME_LENGTH_BY_RULE) { "차의 이름 길이는 $CAR_NAME_LENGTH_BY_RULE 글자를 넘으면 안됩니다" }
    }

    companion object {
        private const val THRESHOLD = 4
        private const val CAR_NAME_LENGTH_BY_RULE = 5
    }
}
