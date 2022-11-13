package racingcar.racingcar

class CarManager {
    fun ready(totalParticipants: Int): List<Car> {
        return List(totalParticipants) { Car() }
    }
}
