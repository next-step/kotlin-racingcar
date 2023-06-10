package racingcar.car

object CarFactory {
    fun getCars(carsCnt: Int): List<Car> = List(carsCnt) { Car(AMGEngine()) }
}
