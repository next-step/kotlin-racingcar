package racing


fun main() {
    val carCount = Input.carCount()
    val playCount = Input.playCount()

    Racing(
        carCnt = carCount,
        roundCnt = playCount
    ).start()

}

