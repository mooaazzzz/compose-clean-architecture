package com.jkdigitals.jkdigitaljetpackcompose.domian.use_case.signIn

import com.jkdigitals.jkdigitaljetpackcompose.common.Resource
import com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto.toSignInResponse
import com.jkdigitals.jkdigitaljetpackcompose.domian.model.SignInRequest
import com.jkdigitals.jkdigitaljetpackcompose.domian.model.SignInResponse
import com.jkdigitals.jkdigitaljetpackcompose.domian.repository.SignInRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: SignInRepository
) {
    operator fun invoke(email: String, password : String): Flow<Resource<SignInResponse>> = flow {
        try {
            emit(Resource.Loading())
            val signIn = repository.signInUser(SignInRequest(email = email, password = password))
            emit(Resource.Success(signIn.toSignInResponse()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: HttpException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

}