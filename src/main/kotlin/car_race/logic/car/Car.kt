package car_race.logic.car

class Car private constructor(
    private var carPosition: CarPosition = CarPosition()
) {
    fun nextRound() {
        carPosition.nextRound()
    }

    fun getPosition(): CarPosition {
        return carPosition
    }

    companion object {
        fun from(): Car {
            return Car()
        }
    }
}
