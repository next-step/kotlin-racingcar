package step3

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
        val result = mutableListOf<List<Int>>()

        for (i in 1..moves) {
            val distances = mutableListOf<Int>()
            cars.forEach {
                distances.add(it.move())
            }
            result.add(distances)
        }

        return result
    }
}
