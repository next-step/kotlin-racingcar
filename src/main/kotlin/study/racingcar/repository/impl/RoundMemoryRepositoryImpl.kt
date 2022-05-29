package study.racingcar.repository.impl

import study.racingcar.domain.Round
import study.racingcar.repository.RoundRepository

class RoundMemoryRepositoryImpl : RoundRepository {

    private var repository: List<Round> = listOf()

    override fun findAll(): List<Round> {
        return repository
    }

    override fun findBy(number: Int): Round {
        return repository.first { it.number == number }
    }

    override fun findLast(): Round {
        return repository.maxByOrNull { it.number }!!
    }

    override fun saveAll(rounds: List<Round>) {
        repository = rounds
    }
}
