package camp.nextstep.edu.racingcar.interfaces

class RacingInputs(private val carNames: List<String>, private val moveCount: Int) {

    operator fun component1() = carNames

    operator fun component2() = moveCount
}
