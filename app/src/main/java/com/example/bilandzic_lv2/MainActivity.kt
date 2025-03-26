package com.example.bilandzic_lv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.TextStyle

import com.example.bilandzic_lv2.ui.theme.Bilandzic_LV2Theme



val antonFontFamily = FontFamily(
    Font(R.font.anton_regular) // Font iz res/font/ direktorija
)

// Definirajte stil za tekstove
val customTextStyle = TextStyle(
    fontFamily = antonFontFamily,
    fontSize = 20.sp,
    color = Color.Black // Prilagodite boju prema želji
)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bilandzic_LV2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserPreview(
                        name = "Luka",
                        visina = 1.91f,  // Primjer visine u metrima
                        tezina = 60f,    // Primjer težine u kilogramima
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun UserPreview(name: String, visina: Float, tezina: Float, modifier: Modifier = Modifier) {
    val bmi = tezina / (visina * visina)
    val formattedBmi = String.format("%.2f", bmi)
    val bmiColor = if (bmi < 20) Color.Green else Color.Red

    Box(modifier = Modifier.fillMaxSize()) {
        // Pozadinska slika
        Image(
            painter = painterResource(id = R.drawable.background_image), // Zamijenite s vašim nazivom slike
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize()
        )

        // UI komponente iznad pozadinske slike
        Column(
            /*verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(16.dp)*/

            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Pozdrav
            Text(
                text = "Pozdrav $name!",
                fontSize = 20.sp,
                fontFamily = antonFontFamily,
                //modifier = Modifier.padding(top = 8.dp,start = 10.dp)
                modifier = Modifier.align(Alignment.Start).padding(top = 8.dp, start = 1.dp)
            )

            //Spacer(modifier = Modifier.height(32.dp))

            // Težina i visina korisnika
            /*Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            )*/

            //Spacer(modifier = Modifier.height(0.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize() // Puni veličinu ekrana
                    .padding(16.dp), // Dodajte padding oko svih komponenata
                contentAlignment = Alignment.Center // Centriranje u sredinu ekrana
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Poravnanje u sredinu
                    verticalArrangement = Arrangement.spacedBy(8.dp), // Razmak između tekstova
                   // modifier = Modifier.fillMaxWidth() // Puni širinu da bi tekst bio u centru
                ) {
                    Text(text = "Tvoja težina: ${tezina} kg", fontSize = 20.sp, fontFamily = antonFontFamily,)
                    Text(
                        text = "Tvoja visina: ${visina * 100} cm",
                        fontSize = 20.sp, fontFamily = antonFontFamily,
                    )  // Pretvori visinu u centimetre

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Tvoj BMI:",
                        fontSize = 25.sp,
                        fontFamily = antonFontFamily,
                        modifier = Modifier.padding(bottom = 1.dp)
                    )
                    Text(
                        text = formattedBmi,
                        fontSize = 55.sp,
                        fontFamily = antonFontFamily,
                        color = bmiColor
                    )

                }
            }

           /* Spacer(modifier = Modifier.height(32.dp))

            // BMI
            Text(
                text = "Tvoj BMI:",
                fontSize = 25.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = formattedBmi,
                fontSize = 55.sp,
                color = bmiColor
            )*/
        }
    }
}

