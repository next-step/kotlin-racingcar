package racing.ui

import racing.domain.ranking.Ranker

class RankingController {
    fun run(record: List<RacingCarDtos>) = Ranker().getWinners(record)
}