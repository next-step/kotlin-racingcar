package step3.infra.io

interface RacingGameInputReader {

    fun readInput(): String

    fun readInputForTotalCarNameList(): List<String>
}
