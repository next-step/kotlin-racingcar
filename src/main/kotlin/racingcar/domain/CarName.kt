package racingcar.domain

class CarName(val name: String) {
    init {
        require(name.length <= VALID_NUMBER) { ERROR_MESSAGE }
    }

    override fun toString(): String {
        return name
    }

    companion object {
        const val ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다."
        const val VALID_NUMBER = 5
    }
}
