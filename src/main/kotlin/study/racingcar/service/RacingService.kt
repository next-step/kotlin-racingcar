package study.racingcar.service

import study.racingcar.dto.RoundResultResponse
import study.racingcar.entity.Car
import study.racingcar.repository.CarRepository
import study.racingcar.util.Move
import java.util.stream.Collectors

class RacingService(private val carRepository: CarRepository) {
    fun intCars(carNames: Set<String>) {
        val cars =
            carNames.stream()
                .map { carName -> Car(carName) }
                .collect(Collectors.toList())
        carRepository.saveAllCars(cars)
    }

    private fun moveCars(cars: List<Car>) {
        cars.forEach { car -> car.move(Move().getRandomMoveCount(), VALID_CONDITION) }
    }

    fun getWinners(): List<Car> {
        val cars = carRepository.findAllCars()
        if (cars.isEmpty()) return emptyList()
        val maxDistance = cars.maxOfOrNull { car -> car.currentPosition } ?: return emptyList()
        return cars.filter { car -> car.currentPosition == maxDistance }.toList()
    }

    fun getGameResultByRound(gameCount: Int): List<RoundResultResponse> {
        val initialCars = carRepository.findAllCars()
        return (ONE..gameCount).map {
            moveCars(initialCars) // 자동차 이동
            RoundResultResponse(initialCars.map { it.clone() })
        }
    }

    companion object {
        private val VALID_CONDITION = 4
        private val ONE = 1
    }
}
