package study.racingcar.repository

import study.racingcar.domain.Round

interface RoundRepository {
    fun findAll(): List<Round>

    fun findBy(number: Int): Round

    fun save(round: Round)
}
