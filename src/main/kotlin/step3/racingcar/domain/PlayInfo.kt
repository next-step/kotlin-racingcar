package step3.racingcar.domain

class PlayInfo(numberOfCars: Int, val totalRound: Int) {
    val cars: Cars = Cars(numberOfCars)
}
