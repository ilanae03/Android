package ilanar03.com.github.Ilan_RM92884_RecycleView

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ilanar03.com.github.Ilan_RM92884_RecycleView.ui.theme.Ilan_RM92884_RecycleViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val praiaAdapter = PraiaAdapter()
        recyclerView.adapter = praiaAdapter

        val buttonIncluir = findViewById<Button>(R.id.buttonIncluir)
        val editTextNomePraia = findViewById<EditText>(R.id.editTextNomePraia)
        val editTextCidade = findViewById<EditText>(R.id.editTextCidade)
        val editTextEstado = findViewById<EditText>(R.id.editTextEstado)

        buttonIncluir.setOnClickListener {
            val nomePraia = editTextNomePraia.text.toString()
            val cidade = editTextCidade.text.toString()
            val estado = editTextEstado.text.toString()

            if (nomePraia.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                if (nomePraia.isEmpty())
                    editTextNomePraia.error = "Preencha o nome da praia"
                if (cidade.isEmpty())
                    editTextCidade.error = "Preencha a cidade"
                if (estado.isEmpty())
                    editTextEstado.error = "Preencha o estado"
                return@setOnClickListener
            }

            val praia = PraiaModel(
                nomePraia = editTextNomePraia.text.toString(),
                cidade = editTextCidade.text.toString(),
                estado = editTextEstado.text.toString(),
                onRemove = {
                    praiaAdapter.removeItem(it)
                }
            )
            praiaAdapter.addItem(praia)


            editTextNomePraia.text.clear()
            editTextCidade.text.clear()
            editTextEstado.text.clear()
        }
    }
}