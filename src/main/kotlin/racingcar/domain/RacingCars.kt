package racingcar.domain

class RacingCars(
    private val cars: List<Car>
) {

    fun execute(movementCommands: List<MovementCommand>) {
        require(cars.size == movementCommands.size) { "이동 명령의 개수가 유효하지 않습니다." }
        cars.zip(movementCommands) { car, command ->
            car.move(command)
        }
    }
}
