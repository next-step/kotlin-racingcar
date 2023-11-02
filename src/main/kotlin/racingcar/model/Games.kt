package racingcar.model

class Games(
    private val cars: Cars,
) {
    fun play() {
        cars.move()
    }

    fun result(): List<Car> {
        return cars.cars
    }

    fun getWinner(): List<Car> {
        return cars.getWinner()
    }

    companion object {
        fun from(input: List<String>): Games {
            return Games(Cars.from(input))
        }
    }
}
