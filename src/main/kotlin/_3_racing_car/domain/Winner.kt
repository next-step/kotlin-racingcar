package _3_racing_car.domain

data class Winner(val racers: Map<String, Int>) {
    fun find(): List<String> {
        val maxLocation: Int = racers.maxOfOrNull { it.value } ?: 0
        return racers.filter { it.value == maxLocation }.map { it.key }
    }
}
