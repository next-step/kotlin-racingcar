package race

class Car(val name: String) {
    val movements: MutableList<Boolean> = mutableListOf()

    init {
        require(name.length < CAR_NAME_LENGTH_BY_RULE) {
            "입력받은 이름: $name, 차의 이름 길이는 $CAR_NAME_LENGTH_BY_RULE 글자를 넘으면 안됩니다"
        }
    }

    fun move(condition: Int) {
        movements.add(condition >= THRESHOLD)
    }

    companion object {
        private const val THRESHOLD = 4
        private const val CAR_NAME_LENGTH_BY_RULE = 5
    }
}
