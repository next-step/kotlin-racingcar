package view

class ViewValidator {
    fun validNumMatch(numMatch: String?): Int {
        return Integer.parseInt(numMatch)
    }

    fun validCarNames(inputNumCar: String?): String {
        if (inputNumCar == null) {
            return " "
        }
        return inputNumCar
    }
}