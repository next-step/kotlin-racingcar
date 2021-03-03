package study.racingcar.step4

class ParticipationCars(participationNameList: List<String>, ableRunNumber: Int) {

    val cars: List<Car> = participationNameList.map { name -> Car(ableRunNumber, name) }
}
