package racingcar.domain

data class CarName(val name: String) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차의 이름은 $MAX_NAME_LENGTH 를 초과할 수 없습니다. 입력값은 $name 입니다." }
        require(name.length >= MIN_NAME_LENGTH) { "자동차의 이름은 $MIN_NAME_LENGTH 보다 작을 수 없습니다. 입력값은 $name 입니다." }
        require(name.isNotBlank()) { "자동차 이름은 공백이 아니어야 합니다." }
    }

    override fun toString(): String {
        return name
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_NAME_LENGTH = 1
    }
}
