package game.domain

class CarNameValidator {
    fun validate(carNames: List<String>) {
        carNames.forEach { carName -> carName.length in 1..5 || throw IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.") }
    }
}
