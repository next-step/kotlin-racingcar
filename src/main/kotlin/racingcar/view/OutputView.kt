package racingcar.view

class OutputView : OutputViewProtocol {

    override fun printLocation(location: Int) {
        for (i in 0 until location) {
            print("-")
        }
        println()
    }

    override fun printName(name: String) {
        print("$name : ")
    }
}
