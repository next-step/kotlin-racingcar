package racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    init {
        when {
            cars.isEmpty() -> {
                throw IllegalArgumentException("자동차 수는 ${MIN_CAR_LENGTH}대 이상이어야 합니다.")
            }
        }
    }

    fun move() {
        cars.forEach(Car::move)
    }

    fun getCars(): List<CarDto> {
        return cars.map { CarDto(it.getName(), it.getLocation()) }
    }

    companion object {
        const val MIN_CAR_LENGTH = 1
    }
}