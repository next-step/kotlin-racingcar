package racingcar.domain

data class Results(val results: List<Result>, val winners: List<Winner>)

data class Winner(val name: String)
