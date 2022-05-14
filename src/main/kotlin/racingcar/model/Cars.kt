package racingcar.model

class Cars(
    private val cars: List<Car>
) {

    init {
        require(cars.isNotEmpty()) {
            "최소 하나의 자동차 이름은 입력해주세요."
        }
    }

    fun moveForwardCars(): Cars {
        return Cars(cars.map {
            it.moveForward()
        })
    }

    fun findWinners(): Cars = Cars(cars.filter { it.position == findMaxPosition() })

    private fun findMaxPosition() = cars.maxOf { it.position }

    fun forEach(action: (Car) -> Unit) = cars.forEach(action)

    fun getCarNameList(): List<CarName> = cars.map { it.name }.toList()
}
