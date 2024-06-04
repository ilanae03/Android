package ilanar03.com.github.Ilan_RM92884_RecycleView

data class PraiaModel(val nomePraia: String, val cidade: String, val estado: String, val onRemove: (PraiaModel) -> Unit)
