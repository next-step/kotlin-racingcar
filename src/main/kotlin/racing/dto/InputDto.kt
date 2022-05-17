package racing.dto

import racing.model.Cars

data class InputDto(val names: List<String>, val round: Int) {
    val cars = Cars.createWithNames(names)
}
