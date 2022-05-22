package _3_racing_car.service.dto

data class RacingOutputDto(val racers: Map<String, Int>) {

    var maxLocation: Int?
        private set

    init {
        maxLocation = racers.maxByOrNull { it.value }?.value
    }

    val winners = racers.filter { it.value == maxLocation }.map { it.key }
}
