package comtqbe.kotlincomposewithlivedata.store.presentation.product_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import comtqbe.kotlincomposewithlivedata.store.domain.model.Product

@Composable
fun ProductCard (
    modifier: Modifier,
    product: Product
){
    Card (
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column (
            modifier = Modifier.padding(15.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds
                )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(4.dp),
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                text = product.title
            )
        }
    }
}