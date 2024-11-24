package car.view

import car.domain.Car
import car.domain.CarRacingGame
import car.domain.MovePossibilities
import car.domain.MovePossibility

class InputView {
    fun input(): CarRacingGame {
        val cars = inputCars()
        val totalRound = inputTotalRound()
        val movePossibilities = makeMovePossibilities(cars.size, totalRound)
        return CarRacingGame(cars, totalRound, movePossibilities)
    }

    private fun inputCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)")
        val maybeCarNames = readlnOrNull()
        requireNotNull(maybeCarNames) { "경주할 자동차 입력은 필수입니다." }

        val carNames = maybeCarNames.split(",")
        return carNames.map { Car(name = it) }
    }

    private fun inputTotalRound(): Int {
        println("시도할 회수는 몇 회인가요?")
        val maybeTotalRound = readlnOrNull()
        requireNotNull(maybeTotalRound) { "실행 횟수 입력은 필수입니다." }
        return try {
            val totalRound = maybeTotalRound.toInt()
            require(totalRound > 0)
            totalRound
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("시도할 회수는 숫자여야 합니다.")
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("시도할 회수는 0보다 커야 합니다.")
        }
    }

    private fun makeMovePossibilities(
        carAmount: Int,
        totalRound: Int,
    ): List<MovePossibilities> =
        (0..<totalRound).map {
            (1..carAmount)
                .map { MovePossibility(generateRandomNumber()) }
                .let { MovePossibilities(it) }
        }

    private fun generateRandomNumber() = (0..10).random()
}