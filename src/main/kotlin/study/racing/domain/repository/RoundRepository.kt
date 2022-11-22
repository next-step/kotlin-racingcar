package study.racing.domain.repository

import study.racing.domain.entity.Record
import study.racing.domain.entity.Round

interface RoundRepository {
    fun getWinner(round: Round): List<Record>
}