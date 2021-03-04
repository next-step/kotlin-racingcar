package racing.domain.ranking

import racing.ui.RacingCarDto
import racing.ui.RacingCarDtos

class Ranker(private val record: List<RacingCarDtos>) {
    val winners: List<String>
        get() {
            val lastRecord = extractLastRecord(record)
            val topScore = calculateTopScore(lastRecord)
            return lastRecord.filter { racingCarDto -> racingCarDto.position == topScore }
                .map { racingCarDto -> racingCarDto.name }
                .toList()
        }

    private fun extractLastRecord(record: List<RacingCarDtos>) = record.last().racingCarDtos

    private fun calculateTopScore(lastRecord: List<RacingCarDto>) =
        lastRecord.maxOf { racingCarDto -> racingCarDto.position }
}