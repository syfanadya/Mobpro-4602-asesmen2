package org.d3if3128.asesmenmobpro2.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3128.asesmenmobpro2.R
import org.d3if3128.asesmenmobpro2.ui.theme.AsesmenMobpro2Theme

const val KEY_ID_PEMINJAMAN = "idPeminjaman"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, id:Long? = null){
    val viewModel: DetailViewModel = viewModel()

    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var judulbuku by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("Sedang Dipinjam") }
    var tanggalpinjam by remember { mutableStateOf("") }
    var tanggalkembali by remember { mutableStateOf("") }

    if(id != null){
        val data = viewModel.getPeminjaman(id)
        nama = data?.nama ?: ""
        nim = data?.nim ?: ""
        nohp = data?.nohp ?: ""
        judulbuku = data?.judulbuku ?: ""
        selectedStatus = data?.status ?: ""
        tanggalpinjam = data?.tanggalpinjam ?: ""
        tanggalkembali = data?.tanggalkembali ?: ""

    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.kembali),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    if(id == null)
                        Text(text = stringResource(id = R.string.tambah_peminjaman))
                    else
                        Text(text = stringResource(id = R.string.edit_peminjaman))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = stringResource(R.string.simpan),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ){ padding ->
        FormPeminjaman(
            name = nama,
            onNameChange = {nama = it},
            number = nim,
            onNumberChange = {nim = it},
            cellnumber = nohp,
            onCellNumberChange = {nohp = it},
            booktitle = judulbuku,
            onBookTitleChange = {judulbuku = it},
            selectedStatus = selectedStatus,
            onStatusSelected = {selectedStatus = it},
            borrowDate = tanggalpinjam,
            onBorrowDateChange = {tanggalpinjam = it},
            returnDate = tanggalkembali,
            onReturnDateChange = {tanggalkembali = it},
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun FormPeminjaman(
    name: String, onNameChange: (String) ->Unit,
    number: String, onNumberChange: (String) -> Unit,
    cellnumber: String, onCellNumberChange: (String) -> Unit,
    booktitle: String, onBookTitleChange: (String) -> Unit,
    selectedStatus: String, onStatusSelected: (String) -> Unit,
    borrowDate: String, onBorrowDateChange: (String) -> Unit,
    returnDate: String, onReturnDateChange: (String) ->Unit,
    modifier: Modifier
){
    val radioOptions = listOf(
        stringResource(id = R.string.status_sedangdipinjam),
        stringResource(id = R.string.status_sudahdikembalikan)
    )
    Column (
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 16.dp, end = 16.dp, bottom = 168.dp)
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        OutlinedTextField(
            value = name,
            onValueChange = {onNameChange(it)},
            label = { Text(text = stringResource(id = R.string.nama))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = number,
            onValueChange = {onNumberChange(it)},
            label = { Text(text = stringResource(id = R.string.nim))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = cellnumber,
            onValueChange = {onCellNumberChange(it)},
            label = { Text(text = stringResource(id = R.string.nohp))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = booktitle,
            onValueChange = {onBookTitleChange(it)},
            label = { Text(text = stringResource(id = R.string.judul_buku))},

            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Column (
            modifier = Modifier
                .padding(top = 6.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ){
            radioOptions.forEach{text ->
                StatusOption(
                    label = text,
                    isSelected = selectedStatus == text,
                    modifier = Modifier
                        .selectable(
                            selected = selectedStatus == text,
                            onClick = {onStatusSelected(text)},
                            role = Role.RadioButton
                        )
                )
            }
        }
        OutlinedTextField(
            value = borrowDate,
            onValueChange = {onBorrowDateChange(it)},
            label = { Text(text = stringResource(R.string.tanggal_pinjam))},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = returnDate,
            onValueChange = {onReturnDateChange(it)},
            label = { Text(text = stringResource(R.string.tanggal_kembali))},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun StatusOption(label: String, isSelected: Boolean, modifier: Modifier){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ){
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview(){
    AsesmenMobpro2Theme {
        DetailScreen(rememberNavController())
    }
}