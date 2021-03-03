package step3

class LapResults(val lapResults: List<LapResult>) {
    fun size() = lapResults.size

    operator fun get(i: Int) = lapResults[i]

    fun findWinners(): Winners {
        val finalRecords = lapResults.last().records
        val winnersPosition = finalRecords.records.maxBy { it.position }?.position

        return Winners(finalRecords.records.filter { it.position == winnersPosition })
    }
}
