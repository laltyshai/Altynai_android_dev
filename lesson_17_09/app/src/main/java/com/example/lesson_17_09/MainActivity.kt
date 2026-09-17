package com.example.lesson_17_09

import android.os.Bundle
import android.widget.Button
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.remote.creation.dsl.random
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_17_09.ui.theme.Lesson_17_09Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lesson_17_09Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    //
//                DiceRoller()
                ImageSelector()


                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    Lesson_17_09Theme {
        Greeting("Android")
    }
}

fun imageById(int: Int) :Int {
    val imageResource = when (int) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    return imageResource
}
@Preview(showBackground = true)

@Composable
fun SelectUi(modifier: Modifier = Modifier) {
    var selected by remember { mutableIntStateOf(value=3) }
//
//    val imageResource = when (selected) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }

    Column(
        modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Choose option")
        Image(

            painter = painterResource(imageById(selected)),
            contentDescription = "selected"
        )
        Text(text = "hi Iskenya $selected")
        for (i in 1..6) {
            Row(
                modifier=Modifier.height(height = 50.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = imageById(i)),
                    contentDescription = "$i"
                )
                Button(onClick = {
                    selected = i
                    println(selected)
                })
                {
                    Text(" select $i")
                }
            }
        }
    }


}
@Preview(showBackground = true)
@Composable
fun ImageSelector() {
    SelectUi(
        Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
    )
}
@Composable

fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var selected by remember { mutableIntStateOf(value=1) }

    val imageResource = when (selected) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier=modifier,
//        verticalArrangement = Arrangement.Vertical,

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "hi Iskenya $selected")
//        Spacer(modifier= Modifier.height(height = 16.dp))
        Image(
            painter = painterResource(imageResource),
            contentDescription = "1"
        )
        Button(onClick = {
                    selected = (1..6).random()
                    println(selected)
        })
        {
            Text(stringResource(R.string.roll))
        }
    }

}
@Composable
fun DiceRoller() {
    DiceWithButtonAndImage(
        Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
    )
}