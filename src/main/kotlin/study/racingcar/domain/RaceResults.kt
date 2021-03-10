package study.racingcar.domain

class RaceResults(
    val raceResultCars: List<Cars>,
    val winners: Winners = Winners(raceResultCars.last().racedCars)
)