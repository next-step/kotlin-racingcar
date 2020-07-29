package racingcar

class RacingGame(
    private val carNames: List<String>,
    private val runCnt: Int
) {
    // TODO start() 테스트 어떻게 하면 좋을지 고민, start() 안의 로직은 각각 테스트했으니 할 필요가 없을지도?
    fun start() {
        val cars = CarFactory.makeCars(carNames)

        for (i in 0 until runCnt) {
            cars.forEach { it.run(flag = (0..9).random()) }
            RecordRepository.save(nth = i, nthRecord = Record(cars))
        }
    }
}
