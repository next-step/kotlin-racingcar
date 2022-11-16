package racingcar.domain.car

import racingcar.domain.car.action.MovingStrategy

data class Cars(val cars: List<Car>) {
    init {
        require(cars.isNotEmpty()) { "빈 문자열은 입력할 수 없습니다." }
        require(cars.size >= 2) { "자동차 이름은 2개 이상 입력해주세요." }
        require(cars.size == cars.distinct().size) { "자동차 이름은 중복될 수 없습니다." }
    }

    constructor(cars: Array<String>) : this(cars.map { Car(it) })

    fun play(movingStrategy: MovingStrategy) {
        cars.forEach { it.move(movingStrategy) }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position.value }
        return cars.filter { it.position.value == maxPosition }.map { it.name.value }
    }
}
