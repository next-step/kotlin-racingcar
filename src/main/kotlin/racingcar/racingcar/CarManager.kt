package racingcar.racingcar

class CarManager {
    fun ready(totalParticipants: Int): List<Car> {
        return (1..totalParticipants)
            .map { Car() }
            .toList()
    }
}
