package model

class Referee(private val racingCars: MutableList<RacingCar>) {
    fun judge(): List<String> {
        var max = 0
        for (car: RacingCar in racingCars) {
            if(max < car.getCurrentState()) {
                max = car.getCurrentState()
            }
        }
        var winnerNames: MutableList<String> = mutableListOf()
        for(car: RacingCar in racingCars) {
            if(car.getCurrentState() == max) {
                winnerNames.addFirst(car.getName())
            }
        }
        return winnerNames
    }
}
