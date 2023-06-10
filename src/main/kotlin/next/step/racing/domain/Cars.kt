package next.step.racing.domain

data class Cars(val cars: List<Car>) {
    companion object {
        private val DEFAULT_POSITION = Position(0)
        fun from(count: Int, pos: Position = DEFAULT_POSITION): Cars {
            return Cars((1..count).map { Car(pos) })
        }
    }

    fun move(drivingStrategy: () -> Int): Cars {
        return Cars(
            cars.map { car ->
                car.move(drivingStrategy)
            }
        )
    }

    fun positions(): List<Int> {
        return cars.map { car ->
            car.position()
        }
    }
}
