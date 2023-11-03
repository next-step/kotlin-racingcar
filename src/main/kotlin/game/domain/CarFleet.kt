package game.domain

class CarFleet(
    private var _cars: Cars,
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator()
) {
    val carList: List<Car>
        get() = _cars.carList

    fun advanceAll() {
        this._cars = _cars.carList
            .map { car -> car.move(moveConditionGenerator.generate()) }
            .let { Cars(it) }
    }
}
