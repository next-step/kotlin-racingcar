package racingcar.car

class CarFactory {
    companion object {
        fun getCars(carsCnt: Int): List<Car> = List(carsCnt) { Car(AMGEngine()) }
    }
}
