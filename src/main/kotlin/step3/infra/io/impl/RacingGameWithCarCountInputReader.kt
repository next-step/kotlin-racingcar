package step3.infra.io.impl

import step3.infra.io.RacingGameInputReader

class RacingGameWithCarCountInputReader : RacingGameInputReader {

    override fun readInput(): String = readln()

    override fun readInputForTotalCarNameList(): List<String> {
        val totalCarCount = readInput().trim().toInt()

        require(totalCarCount > 0) { "totalCarCount should be positive [$totalCarCount]" }

        return (1..totalCarCount).map { "car$it" }
    }
}
