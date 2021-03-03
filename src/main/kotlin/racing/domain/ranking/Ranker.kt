package racing.domain.ranking

import racing.ui.RacingCarDtos

class Ranker {
    fun rank(record: List<RacingCarDtos>): List<String> {
        val lastRecord = record.last().racingCarDtos
        val topScore = lastRecord.maxOf { racingCarDto -> racingCarDto.position }
        return lastRecord.filter { racingCarDto -> racingCarDto.position == topScore }
            .map { racingCarDto -> racingCarDto.name }
            .toList()
    }
}