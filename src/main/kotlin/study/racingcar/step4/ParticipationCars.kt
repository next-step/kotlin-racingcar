package study.racingcar.step4

import study.racingcar.step4.domain.Car

class ParticipationCars(participationNameList: List<String>) {

    val cars: List<Car> = participationNameList.map { name -> Car(name) }
}
