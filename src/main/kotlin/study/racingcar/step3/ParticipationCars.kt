package study.racingcar.step3

class ParticipationCars(participationCount: Int, ableRunNumber: Int) {

    val cars: List<Car> = List(participationCount) { i -> Car(ableRunNumber, i) }
}
