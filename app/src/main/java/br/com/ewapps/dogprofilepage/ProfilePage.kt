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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage() {
    Card(
        elevation = 6.dp, shape = RoundedCornerShape(30.dp), modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 50.dp, start = 16.dp, end = 16.dp)
    ) {
        BoxWithConstraints() {
            val constrains = if (minWidth < 600.dp) {
                portraitConstraints(16.dp)
            } else {
                landscapeConstraints(16.dp)
            }

            //Conteúdo do Card, incluindo todos os elementos
            ConstraintLayout(constrains) {

                Image(
                    painter = painterResource(id = R.drawable.husky),
                    contentDescription = "husky",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp, color = Color.Red, shape = CircleShape
                        )
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )

                Text(
                    "Husky Siberiano",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("nameText")
                )

                Text(text = "Brasil", modifier = Modifier.layoutId("countryText"))


                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")
                ) {
                    ProfileStats(count = "150", title = "Seguidores")
                    ProfileStats(count = "100", title = "Seguindo")
                    ProfileStats(count = "33", title = "Postagens")
                }

                Button(onClick = { /*TODO*/ }, Modifier.layoutId("buttonFollow")) {
                    Text(text = "Seguir Usuário")

                }
                Button(onClick = { /*TODO*/ }, Modifier.layoutId("buttonMessage")) {
                    Text(text = "Mensagem Direta")

                }
            }
        }
    }
}
@Composable
//Funçao que formata o linha de seguidores, seguindo e as postagens
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideline = createGuidelineFromTop(0.25f)
        constrain(image){
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(rowStats){
            top.linkTo(countryText.bottom)
        }
        constrain(buttonFollow){
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(buttonMessage.start)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }

    }
}

private fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideline = createGuidelineFromTop(0.2f)
        constrain(image){
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin = margin)
        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(image.start)
            end.linkTo(image.end)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(rowStats){
            top.linkTo(guideline)
            start.linkTo(image.end, margin = margin)
            end.linkTo(parent.end)
        }
        constrain(buttonFollow){
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(rowStats.start)
            end.linkTo(buttonMessage.start)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(buttonFollow.end)
            end.linkTo(rowStats.end)
            width = Dimension.wrapContent
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}