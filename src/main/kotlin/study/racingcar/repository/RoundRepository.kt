package study.racingcar.repository

import study.racingcar.domain.Round

interface RoundRepository {
    fun findLast(): Round

    fun findAll(): List<Round>

    fun findBy(number: Int): Round

    fun save(round: Round)
}
