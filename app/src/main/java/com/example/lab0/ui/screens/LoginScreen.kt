package com.example.lab0.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab0.R
import com.example.lab0.ui.theme.NavRoutes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val username = remember { mutableStateOf("") }
    val pass = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.lefttop
            ),
            contentDescription = "left top ellipse"
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.rigthcenter),
            contentDescription = "right center ellipse"
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.rightbot
            ),
            contentDescription = "right bot ellipse"
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(bottom = 90.dp)
            ) {
                Column {
                    Text("study ", fontSize = 50.sp, fontWeight = FontWeight.Black)
                }
                Column {
                    Text("IN", fontSize = 50.sp)
                }

            }
            Row(
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                OutlinedTextField(
                    value = "Test",
                    onValueChange = { username.value = it },
                    placeholder = { Text("Create Username") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.moveFocus(FocusDirection.Down)
                    })
                )
            }
            Row(
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                var passwordVisibility: Boolean by remember { mutableStateOf(false) }
                OutlinedTextField(
                    value = "Test",
//                    value = pass.value,
                    onValueChange = { pass.value = it },
                    placeholder = { Text("Create Password") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(painterResource(id = R.drawable.eye), "")
                        }
                    },
                )
            }
            Row(
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                OutlinedTextField(
                    value = "Test",
//                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = { Text("Email ID") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.moveFocus(FocusDirection.Down)
                    })
                )
            }
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Button(
                    onClick = {
                        if (true) {
                            navController.navigate(NavRoutes.List.route)
                        } else {
                            Toast.makeText(
                                context,
                                "Error",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier.width(130.dp)
                ) {
                    Text(text = "Join Us")
                }
            }

        }

    }
}
