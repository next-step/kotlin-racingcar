package step3.racingcar.domain

class MoveStates {
    private var elements: MutableList<MoveStatus> = mutableListOf()

    fun progressRound(randomNumber: Int) {
        elements.add(MoveStatus.match(randomNumber))
    }

    fun calculateMoveCount(): Int =
        elements.stream()
            .filter { it.isGo() }
            .count()
            .toInt()

    fun getElements() = elements
}
