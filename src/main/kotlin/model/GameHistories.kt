package model

class GameHistories(private val histories: MutableList<CarHistories> = mutableListOf()) {
    fun add(racingCars: RacingCars) {
        val carHistories = CarHistories()
        for (racingCar: RacingCar in racingCars.racingCars) {
            carHistories.add(racingCar)
        }
        histories.add(carHistories)
    }

    fun getHistories(): List<CarHistories> {
        return histories.toList()
    }
}
