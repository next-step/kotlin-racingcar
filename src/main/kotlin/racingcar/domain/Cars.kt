package racingcar.domain

class Cars(carNames: List<String>) : List<Car> by (carNames.map { name -> Car(name) })
