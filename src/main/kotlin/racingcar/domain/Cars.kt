package racingcar.domain

class Cars(private val cars: List<Car>) : List<Car> by cars {

    constructor(carNames: CarNames) : this(carNames.mapToCar())

    fun winners(): List<Car> {
        return listOf()
    }

    fun race() {
        
    }
}
