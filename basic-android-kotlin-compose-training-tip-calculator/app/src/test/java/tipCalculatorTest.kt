import com.example.tiptime.calculateTip
import junit.framework.TestCase.assertEquals
import org.junit.Test

class tipCalculatorTest {


    @Test
    fun calculateTip_10PercentNoRoundUp(){
        val amount =20.0
        val tipPercent = 10.0
        val result = 2.0
        val actualRes = calculateTip(amount, tipPercent)
        assertEquals(result, actualRes, 0.0)
    }

}