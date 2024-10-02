package com.example.czerwiec2021

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.czerwiec2021.ui.theme.Czerwiec2021Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Czerwiec2021Theme {
                MenuScreen(this)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Czerwiec2021Theme {
        MenuScreen(context = null)
    }
}

@Composable
fun MenuScreen(context: Context?){
    var switch by remember { mutableStateOf(false) }
    if(switch){
        LoginScreen(context)
    }else{
        RegistrationScreen(context)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                switch = !switch
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (switch) Color(0xFF00FF12) else Color(0xFF008080)
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = if (switch) "Nie masz konta? To je załóż" else "Masz już konto? To się zaloguj",
                color = if (switch) Color.Black else Color.White
            )
        }
    }
}

@Composable
fun RegistrationScreen(context: Context?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0x854CAF50)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rejestruj konto",
            fontSize = 32.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .background(Color(0xFF008080))
                .fillMaxWidth()
                .padding(16.dp)
        )

        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Podaj e-mail:") },
            placeholder = { Text("email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            singleLine = true
        )

        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Podaj hasło:") },
            placeholder = { Text("Hasło") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Text(
                        text = if (passwordVisible) "👁️" else "🙈",
                        fontSize = 24.sp
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            singleLine = true
        )

        var passwordRepeat by remember { mutableStateOf("") }

        OutlinedTextField(
            value = passwordRepeat,
            onValueChange = { passwordRepeat = it },
            label = { Text("Powtórz hasło:") },
            placeholder = { Text("Hasło") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Text(
                        text = if (passwordVisible) "👁️" else "🙈",
                        fontSize = 24.sp
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            singleLine = true
        )

        var message by remember { mutableStateOf("") }

        Button(
            onClick = {
                message = validateInputs(email, password, passwordRepeat)
                if (message == "Witaj $email" && context != null) {
                    saveUserData(context, email, password)
                }
                      },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF008080)
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "ZATWIERDŹ", color = Color.White)
        }
        if (message.isNotEmpty()) {
            Text(
                text = message,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun LoginScreen( context: Context?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0x5B2196F3)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Logowanie",
            fontSize = 32.sp,
            color = Color.Black,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .background(Color(0xFF00FF12))
                .fillMaxWidth()
                .padding(16.dp)
        )

        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Podaj e-mail:") },
            placeholder = { Text("email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            singleLine = true
        )

        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Podaj hasło:") },
            placeholder = { Text("Hasło") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Text(
                        text = if (passwordVisible) "👁️" else "🙈",
                        fontSize = 24.sp
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            singleLine = true
        )

        var message by remember { mutableStateOf("") }

        Button(
            onClick = {
                message = validateLogin(email, password, context)
            },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00FF12)
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Zaloguj się", color = Color.Black)
        }
        if (message.isNotEmpty()) {
            Text(
                text = message,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

fun validateInputs(email: String, password: String, passwordRepeat: String): String {
    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        return "Błąd: Podaj poprawny adres e-mail"
    } else {
        if (password != passwordRepeat) {
            return "Błąd: Hasła nie są takie same"
        } else {
            if (password.length < 8) {
                return "Błąd: Hasło ma zawierać co najmniej 8 znaków"
            } else {
                if (!password.any { it.isDigit() }) {
                    return "Błąd: Hasło musi zawierać przynajmniej jedną cyfrę"
                } else {
                    if (!password.any { "!@#$%^&*()".contains(it) }) {
                        return "Błąd: Hasło musi zawierać przynajmniej jeden znak specjalny"
                    } else {
                        return "Witaj $email"
                    }
                }
            }
        }
    }
}

fun validateLogin(email: String, password: String, context: Context?): String {
    val savedEmail = context?.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        ?.getString("email", "")
    val savedPassword = context?.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        ?.getString("password", "")

    return if (email == savedEmail && password == savedPassword) {
        "Zalogowano pomyślnie! Witaj $email"
    } else {
        "Nieprawidłowy e-mail lub hasło"
    }
}

fun saveUserData(context: Context, email: String, password: String) {
    val sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("email", email)
    editor.putString("password", password)
    editor.apply()
}