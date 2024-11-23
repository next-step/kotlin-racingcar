package misson.car.domain

// 코틀린 문법에서 position을 private으로 하지 않아도 내부적으로는 getter로 접근
class RacingCar(val name: String = "붕붕이", var position: Int = 0) {
    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        require(name.length <= 5) { "이름은 5자 이하만 가능합니다." }
        require(name.isNotBlank()) { "이름은 공백일 수 없습니다." }
    }

    fun move(randomNumberGenerator: () -> Int) {
        if (randomNumberGenerator() >= 4) {
            position++
        }
    }
}
