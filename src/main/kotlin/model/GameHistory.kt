package model

class CarHistories(val histories: MutableList<CarHistory> = mutableListOf()) {
    fun add(racingCar: RacingCar) {
        histories.add(CarHistory(racingCar.name, racingCar.getMoved()))
    }
}
