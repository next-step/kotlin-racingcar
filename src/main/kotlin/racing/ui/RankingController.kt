package racing.ui

import racing.domain.ranking.Ranker

class RankingController {
    fun run(record: List<RacingCarDtos>) = RankingDto.of(Ranker().getWinners(record))
}