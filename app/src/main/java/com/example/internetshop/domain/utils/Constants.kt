package com.example.internetshop.domain.utils

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Constants {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://wvovsjcdowopomwzumhk.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Ind2b3ZzamNkb3dvcG9td3p1bWhrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjU0MzgwMTYsImV4cCI6MjA0MTAxNDAxNn0.H80o0S-Pv5pT0T0ONpLX0WZVyTxlmaSc7aQNdHGQXA4"
    ){
        install(Auth)
        install(Storage)
        install(Postgrest)
    }
}