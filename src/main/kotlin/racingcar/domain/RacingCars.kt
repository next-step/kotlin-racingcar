package racingcar.domain

class RacingCars(
    private val cars: List<Car>
) {
    val size: Int = cars.size

    fun execute(movementCommands: List<MovementCommand>): List<CarState> {
        require(size == movementCommands.size) { "이동 명령의 개수가 유효하지 않습니다." }
        cars.zip(movementCommands) { car, command ->
            car.move(command)
        }

        return cars.map { it.getState() }
    }
}
