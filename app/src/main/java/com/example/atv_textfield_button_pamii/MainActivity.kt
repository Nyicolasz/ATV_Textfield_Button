package com.example.atv_textfild_button_pamii

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atv_textfield_button_pamii.ui.theme.ATV_TextFild_ButtonTheme
import com.example.atv_textfield_button_pamii.ui.theme.NotaIButtonColors
import com.example.atv_textfield_button_pamii.ui.theme.NotaRButtonColors
import com.example.atv_textfield_button_pamii.ui.theme.NotaBButtonColors
import com.example.atv_textfield_button_pamii.ui.theme.NotaMBButtonColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ATV_TextFild_ButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    cadastro()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun cadastro() {
    var nome by remember { mutableStateOf("") }

    Column (Modifier.fillMaxWidth(),){
        Row (Modifier.fillMaxWidth(), Arrangement.Center){
            Image(painter = painterResource(com.example.atv_textfield_button_pamii.R.drawable.logo), contentDescription = "Etec")

            Spacer(modifier = Modifier.width(60.dp)) //Adiciona espaço na vertical

            Text(text = "ATIVIDADE DE PAM II", fontSize = 20.sp)
        }

        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.Center){
            TextField(value = nome, onValueChange = {novoValor -> nome = novoValor},
                label = {Text("Digite seu nome: ")}
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        App(nome)
    }
}



@Composable
private fun App(nome: String) {
    Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.background){
        Column (verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally){

            Spacer(modifier = Modifier.height(80.dp))

            ActionButton(
                text = "Nota I",
                buttonColors = NotaIButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.e(TAG, "App:  $nome Clicou na nota I")
            }

            ActionButton(
                text = "Nota R",
                buttonColors = NotaRButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.w(TAG, "App: $nome Clicou na nota R")
            }

            ActionButton(
                text = "Nota B",
                buttonColors = NotaBButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.i(TAG, "App: $nome Clicou na nota B")
            }

            ActionButton(
                text = "Nota MB",
                buttonColors = NotaMBButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                try{
                    throw RuntimeException("App: Clicou na nota MB")
                }catch (ex: Exception){
                    Log.d(TAG, "App: $nome Clicou na nota MB")
                }
            }
        }
    }
}

@Composable
fun ActionButton(text: String,
                 buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
                 modifier: Modifier = Modifier,
                 block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = Modifier
    )
    {
        Text(text = text)
    }
}