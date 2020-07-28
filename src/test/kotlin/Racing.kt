import org.assertj.core.api.InstanceOfAssertFactories.array
import java.lang.NumberFormatException
data class Circuit(val name:String, val least:String)
class Start {
    fun cars() {
        print("Please Enter number:")
        val cars = readLine()!!.toInt()

        for (i in 0..cars - 1) {
            val result = arrayOf((Circuit(i.toString(),"_")))
        }
    }
}


fun main() {
    val result = Start().cars()
    //println(result.)
}
