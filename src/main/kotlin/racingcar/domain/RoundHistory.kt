package racingcar.domain

data class RoundHistory(val round: Int, val carInfos: List<Pair<String, Int>>)
