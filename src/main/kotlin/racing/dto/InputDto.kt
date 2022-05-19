package racing.dto

data class InputDto(val names: List<String>, val round: Int) {

    init {
        require(names.isNotEmpty())
        require(0 < round)
    }
}
