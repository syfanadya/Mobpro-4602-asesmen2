package org.d3if3128.asesmenmobpro2.navigation

import org.d3if3128.asesmenmobpro2.ui.screen.KEY_ID_PEMINJAMAN

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FromBaru: Screen("detailScreen")
    data object FromUbah: Screen("detailScreen/{$KEY_ID_PEMINJAMAN}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}