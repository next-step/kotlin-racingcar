package study.racingcar.domain

class RaceResult {
    var racedCars: List<Car>
        private set
    constructor(racedCars: List<Car>) {
        this.racedCars = racedCars.map { Car(it.carName, it.moveCount) }
    }
    override fun toString(): String {
        return racedCars.joinToString("\n")
    }
}
