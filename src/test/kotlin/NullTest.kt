import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NullTest {
    @Test
    fun nullTest(){
        var variable: String? = "asd"
        variable = null

        println(variable?.length)
    }
}