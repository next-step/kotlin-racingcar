package step3

class LapResults(val lapResults: List<LapResult>) {
    fun size() = lapResults.size

    operator fun get(i: Int) = lapResults[i]

    fun findWinners(): Winners {
        val lastRecords = lapResults.last().records.records
        val winnersPosition = lastRecords.maxBy { it.position }?.position

        return Winners(lastRecords.filter { it.position == winnersPosition })
    }
}
