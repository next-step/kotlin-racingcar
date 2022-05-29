package study.racingcar.service

import study.racingcar.domain.Car
import study.racingcar.domain.Round
import study.racingcar.repository.RoundRepository

class RacingService(private val roundRepository: RoundRepository) {

    fun start(totalRound: Int, cars: List<Car>) {
        val rounds = (1..totalRound).map {
            race(it, cars)
        }
        roundRepository.saveAll(rounds)
    }

    private fun race(round: Int, cars: List<Car>): Round {
        cars.forEach {
            it.move((1..9).random())
        }

        return Round(round, cars.map { it.copy() })
    }

    fun getAllRounds(): List<Round> {
        return roundRepository.findAll().sortedBy { it.number }
    }

    fun getLastRound(): Round {
        return roundRepository.findLast()
    }
}
