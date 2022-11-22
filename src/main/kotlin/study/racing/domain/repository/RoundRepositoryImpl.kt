package study.racing.domain.repository

import study.racing.domain.entity.Record
import study.racing.domain.entity.Round

class RoundRepositoryImpl : RoundRepository {
    override fun getWinner(round: Round): List<Record> = round.records
        ?.let { records ->
            val winnerPosition = records.maxOf { it.position }
            records
                .filter { it.position == winnerPosition }
        } ?: throw IllegalStateException("아직 시작되지 않은 라운드입니다.")
}