import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.TipTimeLayout
import com.example.tiptime.calculateTip
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class TipUITest {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun calculate_10_percent_tip(){
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip percentage").performTextInput("20")
        composeTestRule.onNodeWithText("TIp Amount: $2.0").assertExists("error message on fail")

    }
}