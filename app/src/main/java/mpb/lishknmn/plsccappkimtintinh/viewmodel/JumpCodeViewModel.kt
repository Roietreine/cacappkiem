package mpb.lishknmn.plsccappkimtintinh.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mpb.lishknmn.plsccappkimtintinh.network.data.RequestModel
import mpb.lishknmn.plsccappkimtintinh.network.data.ResponseModel
import mpb.lishknmn.plsccappkimtintinh.network.repository.JumpServiceImpl
import mpb.lishknmn.plsccappkimtintinh.utils.UiState

class JumpCodeViewModel : ViewModel() {

    private val repo = JumpServiceImpl()

    private val _urlResponse = MutableLiveData<UiState<ResponseModel>>()
    val urlResponse : LiveData<UiState<ResponseModel>>
        get() = _urlResponse

    fun getJumpUrl(packageName: String){
        val param = RequestModel(
            packageName
        )
        viewModelScope.launch {
            repo.getJumpCodeUrl(param)
                .catch { err -> _urlResponse.value = UiState.Error(err) }
                .collectLatest {
                    _urlResponse.value = UiState.Success(it)
                }
        }
    }

}