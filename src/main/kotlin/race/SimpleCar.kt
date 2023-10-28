package race

class SimpleCar(private var location: String = "") {

    fun getCurrentlocation() = location
    fun dice() {
        if ((0..9).random() > 3) location += "-"
    }
}
