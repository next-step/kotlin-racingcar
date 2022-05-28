package study.racingcar.service

import study.racingcar.domain.Car
import study.racingcar.domain.Round
import study.racingcar.repository.RoundRepository

class RacingService(private val roundRepository: RoundRepository) {

    fun start(totalRound: Int, cars: List<Car>) {
        repeat((1..totalRound).count()) {
            race(it, cars)
        }
    }

    private fun race(round: Int, cars: List<Car>) {
        cars.forEach {
            it.move((1..9).random())
        }

        roundRepository.save(Round(round, cars))
    }

    fun getAllRounds(): List<Round> {
        return roundRepository.findAll().sortedBy { it.number }
    }

    fun getLastRound(): Round {
        return roundRepository.findLast()
    }
}
