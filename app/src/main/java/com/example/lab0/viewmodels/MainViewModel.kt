import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab0.api.Common
import com.example.lab0.data.Cat
import com.example.lab0.db.CatDao
import com.example.lab0.db.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repo: CatRepository) : ViewModel() {
    var errorMessage: String by mutableStateOf("")
    var loading: Boolean by mutableStateOf(true)
    var catsList:ArrayList<Cat> by mutableStateOf(arrayListOf())
    val cats = repo.getCatsFromRoom()

    fun requestCatList(){
        viewModelScope.launch {
            try {
                catsList = Common.retrofitService.getCats() as ArrayList<Cat>
                loading = false;
            }
            catch (e: Exception) {
                loading = false;
                errorMessage = e.message.toString()
            }
        }
    }

    fun requestCatListByName(name: String) {
        viewModelScope.launch {
            try {
                catsList = Common.retrofitService.getCatsByName(name) as ArrayList<Cat>
                loading = false;
            }
            catch (e: Exception) {
                loading = false;
                errorMessage = e.message.toString()
            }
        }
    }
}