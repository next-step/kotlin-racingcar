package racingcar.domain

data class Result(val carResults: List<CarResult>)

data class CarResult(val name: String, val distance: Int)
