package racingcar.domain.model

class CarNames(private val carNameList: List<String> = emptyList()) {

    init {
        require(carNameList.isNotEmpty()) { "자동차 이름이 있어야 합니다" }
    }

    fun makeCarRacers(): CarRacers {
        val carRacerList = carNameList.map { name -> CarRacer(name) }
        return CarRacers(carRacerList)
    }
}
