package racingcar.model

class CompeteCar(override val name: String, private val car: Car) : Owner, Car by car {
    override fun goForward(): Car = CompeteCar(name = name, car = car.goForward())
}
