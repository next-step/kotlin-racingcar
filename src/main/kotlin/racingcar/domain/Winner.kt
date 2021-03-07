package racingcar.domain

class Winner(private val positions: List<Positions>) {
    fun names(): List<String> {
        val last = positions.last()
        val mostPosition = last.mostPosition
        return last.filter { it == mostPosition }
            .map { it.name.stringValue() }
    }
}
