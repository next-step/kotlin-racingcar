package racingcar

class RacingCarService(
    private val inputProvider: InputProvider,
    private val carResultProvider: CarResultProvider,
    private val carFactory: CarFactory,
) {
    fun run() {
        val carNames = inputProvider.getStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val attemptNumber = inputProvider.getIntInput("시도할 횟수는 몇 회 인가요?")
        val cars = carFactory.createsCars(carNames)

        repeat(attemptNumber) {
            cars.moveCars()
            carResultProvider.printCars(cars.getCars())
        }

        carResultProvider.printWinners(cars.getWinners())
    }
}
