package domain.racingcar

class OverallResult(private val overallResult: List<Records>) {
    fun forEach(action: (Records) -> Unit) {
        overallResult.forEach(action)
    }

    fun getByIndex(index: Int): Records {
        return overallResult[index]
    }

    fun getSize(): Int {
        return overallResult.size
    }
}
