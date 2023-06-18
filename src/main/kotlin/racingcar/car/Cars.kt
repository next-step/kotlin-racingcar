package racingcar.car

class Cars(
    private val moveStrategy: MoveStrategy,
    carCount: Int
){

    private val cars: MutableList<Car> = mutableListOf()
    init {
        require(carCount > 0) { "자동차는 1대 이상이어야 합니다." }
        repeat(carCount) {
            cars.add(Car(moveStrategy))
        }
    }

    fun move() {
        cars.forEach { it.move() }
    }

    fun getPathStrings(): List<String> {
        return cars.map { it.getPathString() }
    }
}
