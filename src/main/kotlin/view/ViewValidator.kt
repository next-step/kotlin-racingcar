package view

class ViewValidator {
    fun validNumCar(numCar: String?): Int {
        return Integer.parseInt(numCar)
    }

    fun validNumMatch(numMatch: String?): Int {
        return Integer.parseInt(numMatch)
    }
}