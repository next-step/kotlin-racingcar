package racingcar.domain.model

class CarRacers(private val carRacerList: List<CarRacer> = emptyList()) {

    init {
        require(carRacerList.isNotEmpty()) { "자동차 경주자가 있어야 합니다." }
    }

    fun findWinner(): CarRacers {
        val max: Int = carRacerList.maxOf { carRacer -> carRacer.position }
        val winnerList = carRacerList.filter { carRacer -> carRacer.position == max }
        return CarRacers(winnerList)
    }

    fun names(): List<String> {
        return carRacerList.map { carRacer -> carRacer.name }
    }

    fun race() {
        carRacerList.forEach { racer ->
            racer.moveTo(count = (0..9).random())
        }
    }

    fun copy(): List<CarRacer> {
        return carRacerList.map { racer -> racer.copy() }
    }

    fun forEach(eachAction: (CarRacer) -> Unit) {
        carRacerList.forEach(eachAction)
    }

    companion object {

        fun ofCarNames(carNames: CarNames): CarRacers {
            val carRacerList = carNames.carNameList.map { name -> CarRacer(name) }
            return CarRacers(carRacerList)
        }
    }
}
