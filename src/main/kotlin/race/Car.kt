package race

class Car private constructor(val name: String) {
    fun move(randomNumber: Int): Boolean {
        return randomNumber >= THRESHOLD
    }

    companion object {
        private const val THRESHOLD = 4
        private const val CAR_NAME_LENGTH_BY_RULE = 5
        fun from(name: String): Car {
            if (name.length > CAR_NAME_LENGTH_BY_RULE)
                throw IllegalArgumentException("차의 이름 길이는 $CAR_NAME_LENGTH_BY_RULE 글자를 넘으면 안됩니다")
            return Car(name)
        }
    }
}
