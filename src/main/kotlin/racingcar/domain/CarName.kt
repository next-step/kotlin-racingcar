package racingcar.domain

class CarName(val name: String) {

    init {
        require(name.length <= MAX_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_LENGTH: Int = 5
    }
}
