package game.domain

class CarFleet(
    val cars: Cars,
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator()
) {
    fun advanceAll(): CarFleet {
        val cars = cars.carList
            .map { car -> car.move(moveConditionGenerator.generate()) }
            .let { Cars(it) }
        return CarFleet(cars, moveConditionGenerator)
    }
}
