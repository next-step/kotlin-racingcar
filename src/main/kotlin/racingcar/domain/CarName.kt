package racingcar.domain

class CarName(val name: String) {

    init {
        require(name.isNotBlank()) {
            throw IllegalArgumentException("이름은 빈값이 될 수 없습니다.")
        }

        require(name.length < CAR_NAME_MAX_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.")
        }
    }

    companion object {
        private const val CAR_NAME_MAX_LENGTH = 5
    }
}
