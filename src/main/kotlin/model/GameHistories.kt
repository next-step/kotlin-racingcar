package model

class GameHistories(val histories: MutableList<CarHistories> = mutableListOf()) {
    fun add(racingCars: RacingCars) {
        val carHistories = CarHistories()
        for (racingCar: RacingCar in racingCars.racingCars) {
            carHistories.add(racingCar)
        }
        histories.add(carHistories)
    }
}
