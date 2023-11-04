package org.bmsk.racingcar.domain.model

data class Cars(
    private val cars: List<Car>
) {
    val first: Car
        get() = cars.first()

    val names: List<String>
        get() = cars.map { it.name }
}
