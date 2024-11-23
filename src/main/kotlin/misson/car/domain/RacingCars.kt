package misson.car.domain

class RacingCars(val cars: List<RacingCar>) {
    fun moveAll(randomNumberGenerator: () -> Int) {
        cars.forEach { it.move(randomNumberGenerator) }
    }

    // 우승자를 찾는 책임 이동
    fun findWinners(): Winners {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        return Winners(winners)
    }
}
