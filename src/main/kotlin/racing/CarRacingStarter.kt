package racing

class CarRacingStarter {
    fun ready(carNames: List<String>): List<Car> {
        return carNames.validate()
            .map { Car(it) }
    }

    private fun List<String>.validate(): List<String> = onEach {
        require(it.length <= 5) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }
}
