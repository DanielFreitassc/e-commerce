package com.danielfreitassc.store.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.danielfreitassc.store.models.ProductEntity
import com.danielfreitassc.store.viewmodel.ProductViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(viewModel: ProductViewModel = viewModel()) {
    val products = viewModel.products.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Lojinha") })
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }
}

@Composable
fun ProductItem(product: ProductEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            SubcomposeAsyncImage (
                model = product.image,
                contentDescription = product.name,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                },
                error = {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Erro ao carregar", style = MaterialTheme.typography.bodySmall)
                    }
                }
            )

            Spacer(Modifier.width(8.dp))

            Column {
                Text(product.name, style = MaterialTheme.typography.titleMedium)
                Text("R$ ${product.price}")
                Text(product.validity)
                Text(product.description)
            }
        }
    }
}