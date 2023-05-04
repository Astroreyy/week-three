package com.example.pls

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pls.ui.theme.PlsTheme
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    TheUI()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TheUI(){
    Box(    modifier = Modifier.fillMaxSize()
    ){    Image(
        painter = painterResource(id = R.drawable.ignpsreen),
        contentDescription = null,
        modifier = Modifier.fillMaxSize())}
    Column {
        Text(
            text = "LOGIN FORM !",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
           // textAlign = TextAlign.Right,
            fontWeight = FontWeight.W600,
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 150.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        var text by remember { mutableStateOf("") }

        OutlinedTextField(

            value = text,
            onValueChange = {
                text = it
            },
            label = {
                 Text(text ="first name" )
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(16.dp))
        var text1 by remember { mutableStateOf("") }

        OutlinedTextField(

            value = text1,
            onValueChange = {
                text1 = it
            },
            label = {
                Text(text ="last name" )
            }
        ,modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(30.dp))
        var acceptEula by remember {
            mutableStateOf(false)
        }
   Row() {
       Checkbox(checked = acceptEula ,onCheckedChange = { acceptEula = it },modifier = Modifier.padding(start = 100.dp))
       Text("I accept the EULA", modifier = Modifier.padding(13.dp))}
        Spacer(Modifier.width(10.dp))
        val context = LocalContext.current
        Button(onClick = { Toast.makeText(context,"sign up",Toast.LENGTH_SHORT).show()
            }, enabled = (text1.isNotEmpty()&& text.isNotEmpty() && acceptEula),
            modifier = Modifier.align(Alignment.CenterHorizontally))
        {
        Text(text = "SIGN UP")

        }

    }


@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    PlsTheme {

    }
}}