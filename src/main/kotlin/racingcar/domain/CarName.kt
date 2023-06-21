package racingcar.domain

class CarName(val name: String) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차의 이름은 $MAX_NAME_LENGTH 를 초과할 수 없습니다." }
        require(name.length >= MIN_NAME_LENGTH) { "자동차의 이름은 $MIN_NAME_LENGTH 보다 작을 수 없습니다." }
        require(name.isNotBlank()) { "자동차 이름은 공백이 아니어야 합니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_NAME_LENGTH = 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CarName

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return name
    }
}