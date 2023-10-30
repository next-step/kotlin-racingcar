package racingcar.model

class Games(
    private val cars: Cars,
    private val moveCondition: MoveCondition,
) {
    fun play(): List<Car> {
        return cars.move(moveCondition)
    }

    fun getWinner(): List<Car> {
        return cars.getWinner()
    }

    companion object {
        fun of(input: String, moveCondition: MoveCondition): Games {
            return Games(Cars.from(input), moveCondition)
        }
    }
}
