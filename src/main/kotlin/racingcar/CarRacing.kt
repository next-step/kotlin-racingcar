package racingcar

class CarRacing(
    private val carFactory: CarFactory,
    private val promptService: PromptService
) {
    fun run() {
        val cars = carFactory.create(promptService.getNumberOfCars())
        val moves = promptService.getNumberOfMoves()

        val result = startRace(cars, moves)

        promptService.showResult(result)
    }

    fun startRace(cars: List<Car>, moves: Int): List<List<Int>> {
        return List(moves) {
            List(cars.size) { i ->
                cars[i].move()
            }
        }
    }
}
