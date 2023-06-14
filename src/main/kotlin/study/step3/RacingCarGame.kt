package study.step3

class RacingCarGame(
    racingRequest: RacingRequest,
    private val carRandomMove: RandomGenerator
) {

    private val carList: List<Car>

    init {
        carList = prepareRacingCars(racingRequest.carCount)
    }

    fun play(racingRequest: RacingRequest) {
        startRace(racingRequest.tryCount)
    }

    private fun startRace(tryCount: Int) {
        repeat(tryCount) {
            carList.forEach { car ->
                car.move(carRandomMove.randomValue())
            }
        }
    }

    private fun prepareRacingCars(carCount: Int) =
        buildList {
            repeat(carCount) { add(Car()) }
        }

    fun getCurrentCars(): List<Car> = carList
}
