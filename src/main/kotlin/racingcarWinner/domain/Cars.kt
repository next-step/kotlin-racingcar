package racingcarWinner.domain

class Cars(carNames: List<String>) {
    val carList: List<Car> = carNames.map { Car(it.trim()) }
}
