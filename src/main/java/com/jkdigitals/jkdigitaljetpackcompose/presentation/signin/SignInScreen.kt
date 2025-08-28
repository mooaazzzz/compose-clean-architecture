package com.jkdigitals.jkdigitaljetpackcompose.presentation.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jkdigitals.jkdigitaljetpackcompose.R
import com.jkdigitals.jkdigitaljetpackcompose.presentation.signin.components.AppStandardButton
import com.jkdigitals.jkdigitaljetpackcompose.presentation.signin.components.BackgroundImage
import com.jkdigitals.jkdigitaljetpackcompose.presentation.signin.components.Edittext


@Composable
fun SignInScreen(viewModel: SignInViewModel = hiltViewModel()) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val state = viewModel.state.value
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
                    .fillMaxWidth(), text = "Email", value = email, onValueChange = { newValue ->
                    email = newValue
                })
            Edittext(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Password",
                value = password,
                onValueChange = { newValue ->
                    password = newValue
                })

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

            AppStandardButton(onClick = {
                viewModel.signIn(email, password)

            }, text = "LOG IN")

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Don't have an account ")
                    }
                    withStyle(
                        style = SpanStyle(
                            colorResource(id = R.color.bFFC93F),
                            fontFamily = FontFamily(Font(R.font.anebaneue_bold)),
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
