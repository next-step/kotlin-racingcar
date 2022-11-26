package racing.domain

class CarRacing(
    val numOfMove: Int,
    namesOfCars: List<Name>,
    moveStrategy: MoveStrategy,
) {
    private var currentNumOfMove = 0
    private val cars: List<Car> = namesOfCars.map { name -> Car(name, moveStrategy) }

    init {
        require(numOfMove > 0) { "경주 횟수는 0보다 커야합니다." }
    }

    val carInfos: List<CarInfo>
        get() = cars.map { CarInfo(name = it.name, position = it.position) }

    val finish: Boolean
        get() = numOfMove == currentNumOfMove

    fun move() {
        check(numOfMove > currentNumOfMove) { "경기가 끝났습니다." }

        currentNumOfMove++
        cars.forEach(Car::move)
    }

    fun electWinners(): List<CarInfo> {
        check(numOfMove == currentNumOfMove) { "경기가 끝나지 않았습니다." }

        val maxPosition = cars.maxOf(Car::position)

        return cars.filter { maxPosition == it.position }
            .map { CarInfo(name = it.name, position = it.position) }
    }
}
