package com.example.internetshop.view.commonparts.localuser

import android.util.Log
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.model.User
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentUserData() {

    suspend fun RefreshCurrantSession() {
        if (Constants.supabase.auth.currentSessionOrNull() == null) {
            withContext(Dispatchers.IO) {
                try {
                    Constants.supabase.auth.refreshCurrentSession()
                } catch (e: Exception) {
                    Log.e("user", "user session not found")
                }
            }
        }
    }

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
}