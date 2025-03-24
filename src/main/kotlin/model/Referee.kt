package model

class Referee(private val racingCars: RacingCars) {
    fun judge(): List<String> {
        var max = 0
        for (car: RacingCar in racingCars.getRacingCars()) {
            if(max < car.getCurrentState()) {
                max = car.getCurrentState()
            }
        }
        val winnerNames: MutableList<String> = mutableListOf()
        for(car: RacingCar in racingCars.getRacingCars()) {
            if(car.getCurrentState() == max) {
                winnerNames.addFirst(car.getName())
            }
        }
        return winnerNames
    }
}
