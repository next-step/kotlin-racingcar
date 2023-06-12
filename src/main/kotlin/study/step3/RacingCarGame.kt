package study.step3

class RacingCarGame {

    private val carList: MutableList<Car> = mutableListOf()

    fun play(racingRequest: Pair<Int, Int>) {
        prepareRacingCars(racingRequest)
        startRace(racingRequest.second)
    }

    private fun startRace(tryCount: Int) {
        repeat(tryCount) {
            carList.forEach { car -> car.move() }
        }
    }

    private fun prepareRacingCars(racingRequest: Pair<Int, Int>) {
        carList.addAll(
            buildList {
                repeat(racingRequest.first) {
                    add(Car())
                }
            }
        )
    }

    fun getCurrentCars(): List<Car> = carList
}
