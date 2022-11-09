package step3.racingcar.domain

class RoundResults {
    private var elements: MutableList<RoundResult> = mutableListOf()

    fun accumulate(roundResult: RoundResult) = elements.add(roundResult)

    fun addUpAccelerateCount(): Int =
        elements.filter { it.moveStatus.isGo() }
            .count()

    fun size(): Int = elements.size

    fun elements() = elements
}
