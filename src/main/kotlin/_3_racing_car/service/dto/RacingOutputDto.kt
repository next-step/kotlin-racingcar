package _3_racing_car.service.dto

data class RacingOutputDto(val racers: Map<String, Int>) {

    val maxLocation: Int = racers.maxOfOrNull { it.value } ?: 0

    val winners = racers.filter { it.value == maxLocation }.map { it.key }
}
