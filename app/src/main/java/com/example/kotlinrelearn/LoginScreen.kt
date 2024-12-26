@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlinrelearn.R
import com.example.kotlinrelearn.RegisterScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Instagram Logo
        Image(
            painter = painterResource(id = R.drawable.instagram), // Replace with your logo
            contentDescription = "Instagram Logo",
            modifier = Modifier.size(76.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Username TextField
        TextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Phone number, email or username") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = MaterialTheme.shapes.small
                )
                .padding(4.dp), // Optional: Add padding inside the border
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF9F9F9),
                unfocusedIndicatorColor = Color.Transparent, // Remove bottom underline
                focusedIndicatorColor = Color.Transparent // Remove bottom underline
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = MaterialTheme.shapes.small
                )
                .padding(4.dp), // Optional padding inside the border
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF9F9F9),
                unfocusedIndicatorColor = Color.Transparent, // Remove bottom underline
                focusedIndicatorColor = Color.Transparent // Remove bottom underline
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                navController.navigate("feed_screen")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3897F0))
        ) {
            Text(text = "Log In", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot Password Link
        Text(
            text = "Forgot Password?",
            color = Color(0xFF3897F0),
            modifier = Modifier.clickable { /* Handle forgot password */ },
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Divider
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(modifier = Modifier.weight(1f), color = Color.Gray)
            Text(
                text = "OR",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Color.Gray,
                fontSize = 14.sp
            )
            Divider(modifier = Modifier.weight(1f), color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Sign Up Link
        Text(
            text = "Don’t have an account? Sign up.",
            color = Color(0xFF3897F0),
            modifier = Modifier.clickable {
                navController.navigate("register_screen")
            },
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}

