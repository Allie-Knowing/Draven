package com.knowing.draven.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.knowing.domain.base.BadRequest
import com.knowing.domain.base.UnAuthorized
import com.knowing.domain.usecase.auth.FetchGoogleSignInUseCase
import com.knowing.draven.util.MutableEventFlow
import com.knowing.draven.util.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val fetchGoogleSignInUseCase: FetchGoogleSignInUseCase
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    fun googleSignIn(code: String) {
        viewModelScope.launch {
            val authCode = HashMap<String, String>()
            authCode["code"] = code
            kotlin.runCatching {
                fetchGoogleSignInUseCase.invoke(authCode)
            }.onSuccess {
                event(Event.SuccessGoogleSignIn(true))
            }.onFailure {
                httpExceptionHandler(throwable = it)
            }
        }
    }

    private fun httpExceptionHandler(throwable: Throwable) =
        when(throwable){
            is BadRequest -> { event(Event.ErrorMessage("")) }
            is UnAuthorized -> { event(Event.ErrorMessage("")) }
            else -> {}
        }

    sealed class Event {
        data class SuccessGoogleSignIn(var state: Boolean = false) : Event()
        data class ErrorMessage(val errorMessage: String) : Event()
    }
}