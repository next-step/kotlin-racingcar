package camp.nextstep.edu.step.racing.ui

import camp.nextstep.edu.step.racing.domain.Car
import camp.nextstep.edu.step.racing.domain.Cars
import camp.nextstep.edu.step.racing.domain.Tournament

object ResultView {

    fun disPlayCarMoveResult(cars: Cars) {
        println("치열하게 경쟁중!")
        cars.cars.forEach { car -> displayCarsNameAndPosition(car = car) }
        println()
    }

    fun displayTournamentAloneWinnerResult(tournament: Tournament, winner: Car) {
        println("🏆 ${tournament.tournamentName} 대회 결과")
        println("🥇 최종 우승자: ${winner.carName} 축하합니다!")
        println()
    }

    fun displayTournamentJointWinnerResult(tournament: Tournament, winners: List<Car>) {
        println("🏆 ${tournament.tournamentName} 대회 결과")
        winners.forEach { car ->
            println("🥇 공동우승자 우승자: ${car.carName} 축하합니다!")
        }
        println()
    }

    private fun displayCarsNameAndPosition(car: Car) {
        println("${car.carName} : ${"-".repeat(car.position)}")
    }

}
