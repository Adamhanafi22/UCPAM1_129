package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable

fun Layout(modifier: Modifier = Modifier){

    var origin by remember { mutableStateOf("") }
    var depature by remember { mutableStateOf("") }
    var Judul by remember { mutableStateOf("") }
    var Isinya by remember { mutableStateOf("") }

    var dataorigin by remember { mutableStateOf("") }
    var datadepature by remember { mutableStateOf("") }



    var JenisCHT by remember { mutableStateOf("") }
    var CHT by remember { mutableStateOf("") }
    val dataCHT = listOf("Bus","Ship","Train","Plan")

    Column ( modifier = modifier.fillMaxSize().padding(16.dp))
        {
        tampilanHeader()

        Text(text = "Plan your Adventures",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(16.dp))

        TextField(
            value = origin,
            onValueChange = {origin = it},
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            label = {
                Text("origin")

            },
            placeholder = {
                Text("Masukan origin Anda")
            }

        )
        Row  {

            TextField(
                value = depature,
                onValueChange = { depature = it },
                modifier = Modifier.padding(20.dp),

                label = {
                    Text("depature")

                },
                placeholder = {
                    Text("Masukan depature Anda")
                }

            )

        }
        Box(modifier = Modifier.fillMaxWidth().
        background(Color.Blue))
        Column (modifier = Modifier.fillMaxWidth().padding(16.dp))
        {

            Text(
                text = "Choose transportation",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(16.dp))

            Row {

                dataCHT.forEach { selectedJK ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = JenisCHT == selectedJK,
                            onClick = {
                                JenisCHT = selectedJK
                            })
                        Text(selectedJK)

                    }
                }
            }
        }
        Button(onClick = {
            origin = dataorigin
            datadepature = depature


        },
            modifier=Modifier.fillMaxWidth().padding(20.dp)){
            Text("Submmit")
        }
        Card(modifier=Modifier.fillMaxWidth().padding(20.dp)) {
            Column {
                Tampildata(
                    judul =  "origin",
                    isinya = dataorigin,
                )
                Tampildata(
                    judul = "depature",
                    isinya = datadepature,
                )



            }

        }


    }
}



@Composable
fun tampilanHeader() {
    Box(modifier = Modifier.fillMaxWidth().background(Color.Blue)) {
        Column (modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),

                )

            }
            Column (modifier = Modifier.padding(16.dp)){
                Text(text = "Adam Hanafi Putra",
                    color = Color.Yellow,
                    fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(3.dp))
                Text(text = "Kabupaten Lamongan",
                    color = Color.Yellow,
                    fontSize = 17.sp)



            }
        }
    }
}

@Composable
fun  Tampildata(
    judul:String,
    isinya:String
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}