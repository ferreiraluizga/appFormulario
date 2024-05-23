package com.example.formulario

//@author: ferreiraluizga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formulario.ui.theme.FormularioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormularioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){
    var nome by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var nascimento by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        //titulo do app
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(0.dp, 16.dp, 0.dp, 16.dp),
            Arrangement.Center
        ) {
            Text(
                text = "App Formulário",
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        //linha de espaçamento
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
        }

        //imagem do aplicativo
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Image(painter = painterResource(R.drawable.user), contentDescription = null)
        }

        //linha de espaçamento
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
        }

        //campo nome
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange = {nome = it},
                label = { Text(text = "Nome Completo:") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo data de nascimento
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = nascimento,
                onValueChange = {
                    if (it.length < 9){
                        nascimento = it
                    }
                },
                label = { Text(text = "Data de Nascimento:") },
                visualTransformation = DateVisualTransformation(), //aplicação da máscara de data | dd/mm/yyyy
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo de cpf
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = cpf,
                onValueChange = {
                    if (it.length < 12){
                        cpf = it
                    }
                },
                label = { Text(text = "CPF:") },
                visualTransformation = CpfVisualTransformation(), //aplicação da máscara de cpf | xxx.xxx.xxx-xx
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo de gênero
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = genero,
                onValueChange = {genero = it},
                label = { Text(text = "Gênero:") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo de telefone
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = telefone,
                onValueChange = {
                    if (it.length < 12){
                        telefone = it
                    }
                },
                label = { Text(text = "Telefone Celular:") },
                visualTransformation = PhoneVisualTransformation(), //aplicação da máscara de telefone | (xx) xxxxx-xxxx
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
        }

        //linha de espaçamento
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
        }

        //subtitulo1
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(
                text = "Informações de Localização",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        //campo de estado
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = estado,
                onValueChange = {estado = it},
                label = { Text(text = "Estado:") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo de cidade
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = cidade,
                onValueChange = {cidade = it},
                label = { Text(text = "Cidade:") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo de cep
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = cep,
                onValueChange = {
                    if (it.length < 9){
                        cep = it
                    }
                },
                label = { Text(text = "CEP:") },
                visualTransformation = CepVisualTransformation(), //aplicação da máscara de cep | xxxxx-xxx
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo de endereço
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = endereco,
                onValueChange = {endereco = it},
                label = { Text(text = "Endereço:") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }

        //campo de complemento
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = complemento,
                onValueChange = {complemento = it},
                label = { Text(text = "Complemento:") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }

        //linha de espaçamento
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
        }

        //subtitulo2
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        //campo de email
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "E-Mail:") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.AccountCircle,
                        contentDescription = null
                    )
                }
            )
        }

        //campo de senha
        Row(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 8.dp),
            Arrangement.Center
        ) {
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text(text = "Senha:") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = null
                    )
                }
            )
        }

        //check termos de uso
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center,
            Alignment.CenterVertically
        ) {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text(
                text = "Aceite os Termos de Uso"
            )
        }

        //linha de espaçamento
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
        }

        //botão de envio do formulário
        Row(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
            Arrangement.Center
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}

//máscara de telefone
class PhoneVisualTransformation : VisualTransformation {

    // (xx) xxxxx-xxxx
    override fun filter(text: AnnotatedString): TransformedText {

        val phoneMask = text.text.mapIndexed { index, c ->
            when(index) {
                0 -> "($c"
                1 -> "$c) "
                6 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            AnnotatedString(phoneMask),
            PhoneOffsetMapping
        )
    }

    object PhoneOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 6 -> offset + 4
                offset > 1 -> offset + 3
                offset > 0 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 6 -> offset - 4
                offset > 1 -> offset - 3
                else -> offset
            }
        }

    }

}

//máscara de cpf
class CpfVisualTransformation : VisualTransformation {

    // xxx.xxx.xxx-xx
    override fun filter(text: AnnotatedString): TransformedText {

        val cpfMask = text.text.mapIndexed { index, c ->
            when(index) {
                2 -> "$c."
                5 -> "$c."
                8 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            AnnotatedString(cpfMask),
            CpfOffsetMapping
        )
    }

    object CpfOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 8 -> offset + 3
                offset > 5 -> offset + 2
                offset > 2 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 8 -> offset - 3
                offset > 5 -> offset - 2
                offset > 2 -> offset + 1
                else -> offset
            }
        }

    }

}

//máscara de data
class DateVisualTransformation : VisualTransformation {

    // dd/mm/yyyy
    override fun filter(text: AnnotatedString): TransformedText {

        val dateMask = text.text.mapIndexed { index, c ->
            when(index) {
                1 -> "$c/"
                3 -> "$c/"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            AnnotatedString(dateMask),
            DateOffsetMapping
        )
    }

    object DateOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 3 -> offset + 2
                offset > 1 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 3 -> offset - 2
                offset > 1 -> offset - 1
                else -> offset
            }
        }

    }

}

//máscara de cep
class CepVisualTransformation : VisualTransformation {

    // xxxxx-xxx
    override fun filter(text: AnnotatedString): TransformedText {

        val cepMask = text.text.mapIndexed { index, c ->
            when(index) {
                4 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            AnnotatedString(cepMask),
            CepOffsetMapping
        )
    }

    object CepOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 4 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 4 -> offset - 1
                else -> offset
            }
        }

    }

}

@Preview
@Composable
fun AppPreview(){
    FormularioTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App()
        }
    }
}
