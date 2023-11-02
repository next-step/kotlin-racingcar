package game.domain

class CarFleet(
    private var _cars: Cars,
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator()
) {
    val cars: Cars
        get() = _cars

    fun advanceAll() {
        this._cars = _cars.carList
            .map { car -> car.move(moveConditionGenerator.generate()) }
            .let { Cars(it) }
    }
}
