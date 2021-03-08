package study.racingcar.step4.domain

class ParticipationCars(participationNameList: List<String>) {

    val cars: List<Car> = participationNameList.map { name -> Car(name) }
}
