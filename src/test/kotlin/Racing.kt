// import jdk.internal.util.xml.impl.Input
import kotlin.random.Random

// import org.assertj.core.api.InstanceOfAssertFactories.array
// import java.lang.NumberFormatException

interface Inputall{                         // 입력 인터페이스
    fun inputnumber() : Int
    fun inputcircuit(): Int
}


class InputView : Inputall{                 // 입력에 대한 클래스
    override fun inputnumber():Int {        // 참가하는 차의 수 입력 메소드
        print("Please Enter cars number:")
        val carsanswer = readLine()!!.toInt()
        return carsanswer
    }
    override fun inputcircuit(): Int {      // 서킷 수 입력 메소드
        print("Please Enter circuit number:")
        val numbers = readLine()!!.toInt()
        return numbers
    }
}


class Start {                               // 초기 시작 클래스
    fun cars(cars:Int): MutableMap<String,Int>{
        val result:MutableMap<String,Int> = mutableMapOf()
        for (i in 0..cars - 1) {
            result.put("car" +i.toString(),1)
        }
        return result
    }
}
interface Checkcircuit{                     // 유효한 서킷 프린트 해주는 인터페이스
    fun circuitprint(rows: MutableMap<String, Int>)
}
class Printcircuit: Checkcircuit{          // 경주 상황을 프린트 해주는 클래스
    override fun circuitprint(rows:MutableMap<String,Int>) {
        for ((name, number) in rows) {
            println("_".repeat(number))
        }
    println(" ")
    }
}

class Circuit {                            // 경주 실행 및 완주한 차량 확인 클래스
    fun randomcircuit(rows: MutableMap<String, Int>,circuitnumber:Int) : MutableMap<String,Int>{
        var r = 0
        while (r <circuitnumber) {
            for(x in 0..rows.size-1){
                val randomresult = Random.nextInt(10)
                val  carscircuit= rows["car"+x.toString()]
                if (randomresult > 4){
                    if (carscircuit != null) {
                        rows["car"+x.toString()]  = carscircuit.plus(1)
                    }
                }
                r = rows.values.max()!!
            }
            Printcircuit().circuitprint(rows)
        }
        return rows
    }
}


fun main() {
    val car = InputView().inputnumber()
    val maximumcircuit = InputView().inputcircuit()
    val result = Start().cars(car)
    val start =Printcircuit().circuitprint(result)
    Circuit().randomcircuit(result,maximumcircuit)


}
