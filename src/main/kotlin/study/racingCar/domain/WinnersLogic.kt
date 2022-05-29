package study.racingCar.domain

class WinnersLogic {
    fun judgeWinners(mileageRecords: List<List<Pair<String, Int>>>): String {
        val max = mileageRecords.last().maxOf { (_, mileage) -> mileage }
        return mileageRecords.last().filter { (_, mileage) -> mileage == max }.joinToString { it.first }
    }
}