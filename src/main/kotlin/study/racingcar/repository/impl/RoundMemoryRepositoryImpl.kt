package study.racingcar.repository.impl

import study.racingcar.domain.Round
import study.racingcar.repository.RoundRepository

class RoundMemoryRepositoryImpl : RoundRepository {

    private val repository: MutableList<Round> = mutableListOf()

    override fun findAll(): List<Round> {
        return repository
    }

    override fun findBy(number: Int): Round {
        return repository.first { it.number == number }
    }

    override fun save(round: Round) {
        val newRound = Round(round.number, round.cars.map { it.copy() })

        repository.add(newRound)
    }

    override fun findLast(): Round {
        return repository.maxByOrNull { it.number }!!
    }
}
