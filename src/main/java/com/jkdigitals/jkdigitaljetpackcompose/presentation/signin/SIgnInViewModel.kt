package com.jkdigitals.jkdigitaljetpackcompose.presentation.signin


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkdigitals.jkdigitaljetpackcompose.common.Resource
import com.jkdigitals.jkdigitaljetpackcompose.domian.use_case.signIn.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun signIn(email: String, password: String){
        signInUseCase(email, password).onEach {result ->
            when(result)
            {
                is Resource.Success -> {
                    _state.value = SignInState(response = result.data)
                }
                is Resource.Error -> {
                    _state.value = SignInState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = SignInState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
