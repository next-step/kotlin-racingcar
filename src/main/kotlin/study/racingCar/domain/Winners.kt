package study.racingCar.domain

class Winners {
    fun judgeWinners(mileageRecords: List<List<Pair<String, Int>>>): List<String> {
        val winnerMileage = mileageRecords.last().maxOf { (_, mileage) -> mileage }
        return mileageRecords.last().filter { (_, mileage) -> mileage == winnerMileage }.map { it.first }
    }
}
