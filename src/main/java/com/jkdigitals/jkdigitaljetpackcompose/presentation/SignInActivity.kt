package com.jkdigitals.jkdigitaljetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jkdigitals.jkdigitaljetpackcompose.R
import com.jkdigitals.jkdigitaljetpackcompose.presentation.signin.components.BackgroundImage
import com.jkdigitals.jkdigitaljetpackcompose.presentation.ui.theme.JKDigitalJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            JKDigitalJetpackComposeTheme {
                Start()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    JKDigitalJetpackComposeTheme {
        Start()
    }
}

@Composable
fun Start() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        var checked by remember { mutableStateOf(false) }
        BackgroundImage(modifier = Modifier.fillMaxSize(), image = R.drawable.bg_login)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(top = 100.dp),
                text = "SIGN IN",
                color = Color.White,
                fontSize = 40.sp,
                fontFamily = FontFamily(
                    Font(
                        R.font.anebaneue_bold
                    )
                )
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Welcome to JK Digitals!\n" +
                        "Where creativity finds its rhythm.",
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = FontFamily(
                    Font(
                        R.font.anebaneue_regular
                    )
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Edittext(
                modifier = Modifier
                    .fillMaxWidth(), text = "Email", value = "", onValueChange = {})
            Edittext(
                modifier = Modifier
                    .fillMaxWidth(), text = "Password", value = "", onValueChange = {})

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp),

                verticalAlignment = Alignment.CenterVertically
            )
            {
                Checkbox(

                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = colorResource(id = R.color.bFFC93F),
                        uncheckedColor = colorResource(id = R.color.b697B84),
                    )
                )

                Text(
                    text = "Remember me",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.anebaneue_semibold))
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    fontSize = 14.sp,
                    text = "Forgot password",
                    color = colorResource(id = R.color.bFFC93F),
                    fontFamily = FontFamily(Font(R.font.anebaneue_semibold)),
                )
            }

            AppStandardButton(onClick = { /*TODO*/ }, text = "LOG IN")

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Don't have an account ")
                    }
                    withStyle(
                        style = SpanStyle(colorResource(id = R.color.bFFC93F),
                            fontFamily = FontFamily( Font(R.font.anebaneue_bold)),
                            textDecoration = TextDecoration.Underline
                            )
                    ) {
                        append("Sign Up")
                    }
                }

            )
        }
    }
}

@Composable
fun Edittext(
    modifier: Modifier = Modifier,
    text: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .defaultMinSize(),
            text = text,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.anebaneue_bold)),
            color = Color.White
        )
        Spacer(
            modifier = Modifier
                .height(7.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.b181818), RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
        )

    }
}


@Composable
fun AppStandardButton(onClick: () -> Unit, text: String) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_0),
            colorResource(id = R.color.gradient_25),
            colorResource(id = R.color.gradient_50),
            colorResource(id = R.color.gradient_75),
            colorResource(id = R.color.gradient_100),
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .height(50.dp)
            .background(brush = gradient, shape = RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.gradient_0),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = buttonColors(containerColor = Color.Transparent), // Make button background transparent
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Text(
                text = text,
                color = colorResource(id = R.color.white),
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.anebaneue_bold))
            )
        }
    }
}


