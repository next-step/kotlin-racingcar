package study.step3

class RacingCarGame {

    private val carList: MutableList<Car> = mutableListOf()

    fun play(racingRequest: RacingRequest) {
        prepareRacingCars(racingRequest.carCount)
        startRace(racingRequest.tryCount)
    }

    private fun startRace(tryCount: Int) {
        repeat(tryCount) {
            carList.forEach { car ->
                val randomValue = RandomGenerator().generateRandomValue()
                car.move(randomValue >= 4)
            }
        }
    }

    private fun prepareRacingCars(carCount: Int) {
        carList.addAll(
            buildList {
                repeat(carCount) { add(Car()) }
            }
        )
    }

    fun getCurrentCars(): List<Car> = carList
}
