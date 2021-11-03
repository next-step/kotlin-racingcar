package racingcar.domain.car

import racingcar.domain.engine.CarEngine

@JvmInline
value class Cars(private val _cars: List<Car>) {

    val cars: List<Car>
        get() = _cars.toList()

    private fun findMaxPosition(): Int? = cars.maxByOrNull { it.position }?.position

    fun movePositions() = _cars.map { it.movePosition() }

    fun findWinners(): List<Car> {
        return cars.filter { it.position == findMaxPosition() }.toList()
    }

    companion object {
        fun newInstance(carNames: List<String>, engine: CarEngine): Cars = Cars(carNames.map { Car(CarName(it), carEngine = engine) })
    }
}
