package domain.racingcar

class OverallResult(val overallResult: List<Records>) {
    fun getByIndex(index: Int): Records {
        return overallResult[index]
    }

    fun getSize(): Int {
        return overallResult.size
    }
}
