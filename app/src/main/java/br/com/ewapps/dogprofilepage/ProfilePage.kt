package br.com.ewapps.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage(){
    Card(elevation = 6.dp, shape = RoundedCornerShape(30.dp), modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        ) {
    //COnteúdo do Card, incluindo todos os elementos
        Column(
        Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
Image(painter = painterResource(id = R.drawable.husky),
    contentDescription = "husky",
modifier = Modifier
    .size(200.dp)
    .clip(CircleShape)
    .border(
        width = 2.dp, color = Color.Red, shape = CircleShape
    ),
    contentScale = ContentScale.Crop
)

        Text("Husky Siberiano")
        Text(text = "Brasil")

        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            ProfileStats(count = "150", title = "Seguidores")
            ProfileStats(count = "100", title = "Seguindo")
            ProfileStats(count = "33", title = "Postagens")
        }

        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Seguir Usuário")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Mensagem Direta")
            }
        }
    }
    }
}

@Composable
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}