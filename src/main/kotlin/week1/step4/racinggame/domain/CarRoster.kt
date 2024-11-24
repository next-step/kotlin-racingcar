package week1.step4.racinggame.domain

@JvmInline
value class CarRoster(private val carNames: List<CarName>) {
    init {
        require(carNames.isNotEmpty()) {
            "레이싱 게임을 하기 위해서는 차가 1대 이상이어야 합니다."
        }
    }

    fun createCars(): List<Car> {
        return carNames.map { Car(it) }
    }
}
