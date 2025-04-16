package com.github.rafaelgribe.dnemock

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.rafaelgribe.dnemock.ui.theme.DNEMockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DNEMockTheme {
                Root()
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Root() {
    Scaffold(
        containerColor = colorResource(R.color.background_2025), modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dne_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth(0.4F)
                )
                Image(
                    painter = painterResource(id = R.drawable.anpg_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth(0.3F)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(top = 40.dp)
                    .height(IntrinsicSize.Max),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = Color.White)
                        .padding(4.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_picture),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(6.dp))
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color.White),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.qr_code),
                        contentDescription = "Profile Picture",
                        modifier = Modifier.padding(12.dp)
                    )
                    Text(
                        text = "Cod. uso 2025.QEJGDB", fontWeight = FontWeight.SemiBold, fontSize = 12.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "RAFAEL GOMES RIBEIRO", fontWeight = FontWeight.Bold)
                }
                TextRow(field = "Ins. Ensino", value = "Universidade de Uberaba")
                TextRow(field = "Curso", value = "Ciência de Dados e Big Data")
                TextRow(field = "Nível de ensino", value = "Pós Graduação")
                TextRow(field = "CPF", value = "126.841.246-55")
                TextRow(field = "Data de Nasc.", value = "08/12/1996")
                TextRow(field = "Validade", value = "03/2026")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Button(
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0, 0, 0, 35),
                        contentColor = Color.White,
                    ),
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.verified_user_24),
                        contentDescription = "Check",
                        modifier = Modifier.padding(end = 6.dp)
                    )
                    Text(text = "Certificado")
                }
            }
        }
    }
}

@Composable
fun TextRow(field: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "$field:",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 3.dp)
        )
        Text(text = value)
    }
}