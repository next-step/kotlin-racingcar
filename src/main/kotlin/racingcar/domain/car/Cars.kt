package racingcar.domain.car

import racingcar.domain.engine.CarEngine

@JvmInline
value class Cars(private val cars: List<Car>) {

    private fun findMaxPosition(): Int? = cars.maxByOrNull { it.position }?.position

    fun movePositions() = cars.map { it.movePosition() }

    fun findWinners(): List<Car> {
        return cars.filter { it.position == findMaxPosition() }.toList()
    }

    companion object {
        fun newInstance(carNames: List<String>, engine: CarEngine): Cars = Cars(carNames.map { Car(CarName(it), carEngine = engine) })
    }
}
