import kotlin.random.Random

class Car {

    var progreessString = StringBuffer("-")

    fun getCarProgress() : String {
        if(checkCanGo()) {
            progreessString.append("-")
        }
        return progreessString.toString()
    }

    fun checkCanGo() : Boolean {
        return getRandomInt() >= 4
    }

    fun getRandomInt() : Int{
        return Random.nextInt(0, 10)
    }
}