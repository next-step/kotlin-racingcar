package step3

class RacingGame {
    private val _carList = mutableListOf<Car>()
    val carList: List<Car>
        get() = _carList

    fun play(cars: Int, times: Int) {
        repeat(times) {
            repeat(cars) {
                if (_carList.getOrNull(it) == null) _carList.add(it, Car())
                _carList[it].run()
                ResultView().printRacingResult(_carList[it].getRecords())
            }
            ResultView().printNextRacing()
        }
    }
}
