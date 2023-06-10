package next.step.racing.domain

data class Cars(val cars: List<Car>) {
    companion object {
        fun init(count: Int): Cars {
            return Cars((1..count).map { Car.init() })
        }

        fun at(count: Int, pos: Position): Cars {
            return Cars((1..count).map { Car.at(pos) })
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
