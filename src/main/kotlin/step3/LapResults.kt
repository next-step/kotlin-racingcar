package step3

class LapResults(val lapResults: List<LapResult>) : List<LapResult> by lapResults {
    fun getWinners(): Winners {
        val finalRecords = lapResults.last().records
        val winnersPosition = finalRecords.maxBy { it.position }?.position

        return Winners(finalRecords.filter { it.position == winnersPosition })
    }
}
