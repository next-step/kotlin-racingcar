package step3.infra.io

class RacingGameInputReader {

    @Deprecated("since step4")
    fun readInputForTotalCarCount(): Int {
        val totalCarCount = readInput().trim().toInt()

        require(totalCarCount > 0) { "totalCarCount should be positive [$totalCarCount]" }

        return totalCarCount
    }

    fun readInputForTotalTryCount(): Int {
        val totalTryCount = readInput().trim().toInt()

        require(totalTryCount > 0) { "totalTryCount should be positive [$totalTryCount]" }

        return totalTryCount
    }

    private fun readInput(): String = readln()

    fun readInputForCarNameList(): List<String> {
        val carNameList = readInput().trim().split(",")

        require(carNameList.isNotEmpty()) { "carNameList sholud be not empty [$carNameList]" }

        return carNameList
    }
}
