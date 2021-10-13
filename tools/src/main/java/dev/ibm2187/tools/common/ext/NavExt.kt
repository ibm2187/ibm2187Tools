package dev.ibm2187.tools.common.ext

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import dev.ibm2187.tools.R


val navOptions = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setExitAnim(R.anim.slide_out_left)
    .setPopEnterAnim(R.anim.slide_in_left)
    .setPopExitAnim(R.anim.slide_out_right)
    .build()

fun NavDirections.navigateWith(fragment: Fragment) {
    val actionId = this.actionId

    val navController = fragment.findNavController()
    val currentDestination = navController.currentDestination

    val action = currentDestination?.getAction(actionId)
        ?: navController.graph.getAction(actionId)


    if (action != null)
        navController.navigate(this, navOptions)
}