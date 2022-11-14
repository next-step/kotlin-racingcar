package step3.racingcar.domain

class RoundResults {
    private val elements: MutableList<RoundResult> = mutableListOf()

    fun accumulate(roundResult: RoundResult) = elements.add(roundResult)

    fun acceleratedCount(): Int =
        elements.filter { it.moveStatus.isGo() }
            .count()

    fun size(): Int = elements.size

    fun elements() = elements.toList()
}
