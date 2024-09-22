package com.example.internetshop.view.commonparts.localuser

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.model.User
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentUserData() {
    suspend fun GetSpecificUserData() {
        if (Constants.supabase.auth.currentSessionOrNull() != null) {
            UserSpecificData.id.value = Constants.supabase.auth.currentUserOrNull()!!.id
            try {
                UserSpecificData.Role.value =
                    Constants.supabase.from("User")
                        .select() {
                            filter {
                                eq("id", UserSpecificData.id.value)
                            }
                        }.decodeSingle<User>().Role
                //Log.e("user", UserSpecificData.Role.value.toString())
            } catch (e: Exception) {
                Log.e("user", "Error")
                Log.e("user", e.message.toString())
            }
        } else {
            UserSpecificData.Role.value = 0
            //Log.e("user", UserSpecificData.Role.value.toString())
        }
    }

    suspend fun GetDataCurrantUerOnNUll(): User? {

        val user = mutableStateOf(
            User(
                id = "11111111111111",
                Name = "User",
                Email = "user@user.com",
                ProfileImage = null,
                Role = 2
            )
        )

        if (Constants.supabase.auth.currentSessionOrNull() != null) {
            try {
                user.value =
                    Constants.supabase.from("User")
                        .select() {
                            filter {
                                eq("id", UserSpecificData.id.value)
                            }
                        }.decodeSingle<User>()

                //Log.e("user", user.value.toString())

                return user.value
            } catch (e: Exception) {
                Log.e("user", "Error")
                Log.e("user", e.message.toString())
            }
        } else {
            Log.e("user", "user wasn auth")
        }

        return null
    }
}
