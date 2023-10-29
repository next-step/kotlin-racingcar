package racingcar.model

data class Cars(
    val cars: List<Car>,
) {
    fun move(moveStrategy: MoveStrategy): Cars {
        this.cars.map { if (moveStrategy.isMovable()) it.move() }
        return Cars(this.cars)
    }

    companion object {
        fun createCar(count: Int): Cars {
            return Cars(
                List(count) {
                    Car.of()
                }
            )
        }
    }
}
