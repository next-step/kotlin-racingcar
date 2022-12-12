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

    fun copy(): CarRacers {
        val carRacerList = carRacerList.map { racer -> racer.copy() }
        return CarRacers(carRacerList)
    }

    fun forEach(eachAction: (CarRacer) -> Unit) {
        carRacerList.forEach(eachAction)
    }
}
