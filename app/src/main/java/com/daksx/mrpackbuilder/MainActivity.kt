
package com.daksx.mrpackbuilder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Accent = Color(0xFFF58888)
private val Dark = Color(0xFF171719)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var packName by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf("Mods") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark)
            .padding(20.dp)
    ) {
        Text(
            "DAKSX",
            color = Accent,
            fontSize = 28.sp
        )
        Text(
            "MRPack Builder",
            color = Color.White,
            fontSize = 20.sp
        )

        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = packName,
            onValueChange = { packName = it },
            label = { Text("Modpack name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Text("Create your modpack", color = Color.White)

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { selectedTab = "Mods" },
            colors = ButtonDefaults.buttonColors(
                containerColor = Accent
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Browse Mods", color = Dark)
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { selectedTab = "Dependencies" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Dependency Manager")
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { selectedTab = "Validation" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pre-Export Validation")
        }

        Spacer(Modifier.height(24.dp))

        Text(
            "Selected section: $selectedTab",
            color = Accent
        )

        Text(
            "Your modpack tools will appear here.",
            color = Color.LightGray
        )
    }
}
