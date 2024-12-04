package racingcar.domain

class Winners(scores: List<Score>) {
    private val _names: List<CarName> = scores.map { CarName(it.carName) }
    val names: List<CarName>
        get() = _names.toList()
}
