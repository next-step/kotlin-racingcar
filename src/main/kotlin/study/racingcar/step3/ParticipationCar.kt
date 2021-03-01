package study.racingcar.step3

class ParticipationCar(private val participationCount: Int) {

    private val cars: List<Car> = List(participationCount) { i -> Car(4, i) }

    fun getRacingCars(): List<Car> {
        return cars
    }
}
