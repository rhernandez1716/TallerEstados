package me.rodolfohernandez.statecompose2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Dado(modifier: Modifier = Modifier) {
    val caras = listOf(
        R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
        R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6
    )

    var numero by rememberSaveable { mutableStateOf(1) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = caras[numero - 1]),
            contentDescription = "Dado mostrando el número $numero",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { numero = (1..6).random() }) {
            Text("Lanza el dado!!!!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DadoPreview() {
    Dado(modifier = Modifier.fillMaxSize())
}

