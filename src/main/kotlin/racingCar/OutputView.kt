package racingCar

object OutputView {

    fun getCarRacingResult(racingCarResult: Car) {
        // 최종결과값 주기?
        // racingCarResult.forEach { car -> makeRacingMap(car.distance)}
        // 한대씩 결과값 출력하기
        println(racingCarResult.distance)
        makeRacingMap(racingCarResult.distance)
    }

    fun makeRacingMap(distance: Int) {
        val mapSign = "="
        for (i in 0..distance) {
            print(mapSign)
        }
        println()
    }
}
