package racing


fun main() {
    val carCount = Input.carCount()
    val playCount = Input.playCount()

    Racing(
        carCount = carCount,
        roundCount = playCount
    ).start()

}

