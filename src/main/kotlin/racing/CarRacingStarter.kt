package racing

class CarRacingStarter {
    fun ready(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }
}
