package racingcar.domain

class CarName(name: String) {
    val value: String

    init {
        if (name.length > 5) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
        this.value = name
    }
    companion object {
        const val ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다."
    }
}
