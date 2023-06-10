class ResultView {
    fun carsDistanceDisplay(distance: Int) {
        var displayString = ""
        for (i in 1..distance) {
            displayString = "$displayString-"
        }
        println(displayString)
    }
}
